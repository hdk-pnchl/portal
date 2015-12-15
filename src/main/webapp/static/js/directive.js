var directiveM= angular.module('directiveM', []);

directiveM.directive("portalTable",function(){
    return {
        restrict: "E",
        templateUrl: "html/directive/portalTable.html",
        scope: {
            data: "=",
            editfn: '&',
            viewfn: '&',
            deletefn: '&'
        },
        controller: function($scope) {
            $scope.searchRow=   {};
            $scope.selectedRow = null;
            $scope.summary= {};
            //$scope.active=   false;            
            $scope.sort= function(sortCol) {
                $scope.sortCol = sortCol;
                $scope.sortOrder = !$scope.sortOrder;
            };        
            $scope.selectRow = function(selectedRow){
                $scope.selectedRow= selectedRow;
                angular.forEach($scope.data.rowData, function(currentRow){
                  currentRow.selected = false;
                });
                selectedRow.selected = true;
            };
            $scope.fetchSummary= function(row) {
                $scope.summary.data= row;
                $scope.summary.active= true;
                $scope.summary.size= Object.keys(row).length;
                $scope.summary.colSize= Object.keys(row).length;
            }           
            //--row actions 
            $scope.rowSelectionCheck= function(){
                if(!$scope.selectedRow){
                    alert("Please select 1 row!");
                    return false;
                }
                return true;
            };               
            $scope.editRow= function(){
                if($scope.rowSelectionCheck()){
                    $scope.editRowUpdate($scope.selectedRow);
                }
            };
            $scope.viewRow= function(){
                if($scope.rowSelectionCheck()){
                    $scope.viewRowUpdate($scope.selectedRow);
                }
            };
            $scope.deleteRow= function(){
                if($scope.rowSelectionCheck()){
                    $scope.deleteRowUpdate($scope.selectedRow);
                }
            };                        
        },
        link: function($scope, element, attrs, controllers){
            $scope.editRowUpdate = function(editRow) {
                //alert("editRowUpdate");
                $scope.editfn({
                    "editRow": editRow,
                });
            };
             $scope.viewRowUpdate = function(viewRow) {
                //alert("viewRowUpdate");
                $scope.viewfn({
                    "viewRow":viewRow,
                });
            };
            $scope.deleteRowUpdate = function(deleteRow) {
                //alert("deleteRowUpdate");
                $scope.deletefn({
                    "deleteRow":deleteRow,
                });
            };                       
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
            };
        }
    };
}]);

directiveM.directive('portalSummaryPage', ['$compile', '$parse', function ($compile, $parse) {
    return {
        restrict: 'E',
        templateUrl: 'html/directive/portalSummaryPage.html',
        scope: {
            summaryData: '=',
            actionfn: '&'
        },
        controller: function($scope, $element, $attrs, $transclude) {
            $scope.someVal= "djhdfjhdjfhjhfjdf";
            $scope.isObjProp= function(val){
                var isObj= angular.isObject(val);
                return isObj;
            }
        },
        link: function($scope, element, attrs, controllers){
        }
    };
}]);



