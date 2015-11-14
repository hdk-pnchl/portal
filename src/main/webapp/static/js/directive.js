var directiveM= angular.module('directiveM', []);

directiveM.directive("portalTable",function(){
    return {
        restrict: "E",
        templateUrl: "html/directive/portalTable.html",
        scope: {
            data: "="
        },
        controller: function($scope) {
            $scope.searchRow=   {};
            $scope.sort= function(sortCol) {
                $scope.sortCol = sortCol;
                $scope.sortOrder = !$scope.sortOrder;
            }        
            $scope.selectedRows = [];
            $scope.selectRow = function(row){
                if(row.selected){
                    row.selected = false;       
                    var index = $scope.selectedRows.indexOf(row);
                    $scope.selectedRows.splice(index-1, 1);
                }else{
                    row.selected = true;    
                    $scope.selectedRows.push(row);
                }
            }
            $scope.summary=   {};
            $scope.active=   false;
            $scope.fetchSummary= function(row) {
                $scope.summary.data= row;
                $scope.summary.active= true;
                $scope.summary.size= Object.keys(row).length;
                $scope.summary.colSize= Object.keys(row).length;
            }
        }
    }; 
});

directiveM.directive('banner', function(){
  	return {
  		restrict: 'E',
  		templateUrl: 'html/directive/banner.html',
	    scope: {
	      	bannerData: '='
	    },
	    controller: function($scope) {
	      	$scope.selectTab = function(tab) {
		        angular.forEach($scope.bannerData.navData.mainNavData, function(tab){
		          tab.active = false;
		        });
		        angular.forEach($scope.bannerData.navData.configNavData, function(tab){
		          tab.active = false;
		        });		        
		        tab.active = true;
	      	};
	      	$scope.selectHome = function() {
		        angular.forEach($scope.bannerData.navData.mainNavData, function(tab){
		          tab.active = false;
		        });
		        angular.forEach($scope.bannerData.navData.configNavData, function(tab){
		          tab.active = false;
		        });		        
		        $scope.bannerData.navData.mainNavData[0].active = true;
	      	};	      	
	    },
	    link: function(scope, element, attrs, controllers){
	    	//console.log("scope: "+scope.bannerData);
	    }
  	};
});

directiveM.directive('dynamicmodel', ['$compile', '$parse', function ($compile, $parse) {
    return {
        restrict: 'A',
        terminal: true,
        priority: 100000,
        link: function (scope, elem){
            var name = $parse(elem.attr('dynamicmodel'))(scope);
            elem.removeAttr('dynamicmodel');
            elem.attr('ng-model', name);
            $compile(elem)(scope);
        }
    };
}]);

directiveM.directive('portalForm', ['$compile', '$parse', function ($compile, $parse) {
    return {
        restrict: 'E',
        templateUrl: 'html/directive/portalForm.html',
        scope: {
            formData: '=',
            actionfn: '&'
        },
        controller: function($scope, $element, $attrs, $transclude) {
            $scope.submitForm= function(){
                $scope.callUpdate($scope.formData.name, $scope[$scope.formData.modalDataObj])
            }
        },
        link: function($scope, element, attrs, controllers){
            $scope[$scope.formData.modalDataObj]= {}; 
            $scope.callUpdate = function(patientDataType, patientData) {
                $scope.actionfn({
                    "patientDataType":patientDataType,
                    "patientData":patientData
                });
            }
        }
    };
}]);



