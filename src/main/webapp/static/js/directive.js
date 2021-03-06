var directiveM= angular.module('directiveM', []);

/* -----------------BANNER-----------------*/

directiveM.directive('banner', function(){
    return {
        restrict: 'E',
        templateUrl: 'html/directive/banner.html',
        scope: {
            bannerData: '='
        },
        controller: function($scope, $rootScope, $location) {
            $scope.selectTab = function(tab) {
                if(tab){
                    angular.forEach($scope.bannerData.navData.mainNavData, function(tab){
                      tab.active = false;
                    });
                    angular.forEach($scope.bannerData.navData.configNavData, function(tab){
                      tab.active = false;
                    });
                    tab.active = true;
                }
            };

            $rootScope.$on("$locationChangeSuccess", function(event, newUrl, oldUrl, newState, oldState){ 
                var xTabName= $location.path().split("/")[1];
                var xTab= $scope.bannerData.navData.mainNavData[xTabName];
                $scope.selectTab(xTab);
            });

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

/* -----------------TABLE-----------------*/

directiveM.directive("portalTable",function(){
    return {
        restrict: "E",
        templateUrl: "html/directive/portalTable.html",
        scope: {
            data: "=",
            searchfn: '&',
            editfn: '&',
            viewfn: '&',
            deletefn: '&'
        },
        controller: function($scope) {
            $scope.searchRow= {};
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
                //if($scope.rowSelectionCheck()){
                $scope.viewRowUpdate($scope.selectedRow);
                //}
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
            $scope.searchData= function(pageNo, rowsPerPage){
                var searchIp= {};
                searchIp.pageNo= pageNo;
                searchIp.rowsPerPage= rowsPerPage;
                searchIp.searchData= {};                
                $scope.searchDataUpdate(searchIp);
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
            $scope.searchDataUpdate = function(searchIp) {
                //alert("deleteRowUpdate");
                $scope.searchfn({
                    "searchIp": searchIp,
                });
            };                        
        }        
    }; 
});

/* -----------------FORM-----------------*/

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
                $scope.actionfn({
                    "dataType": $scope.formData.name,
                    "data": $scope.formData.data
                });                
            }
        },
        link: function($scope, element, attrs, controllers){
        }
    };
}]);

/* -----------------SUMMARY-----------------*/

directiveM.directive('portalSummaryPage', ['$compile', '$parse', function ($compile, $parse) {
    return {
        restrict: 'E',
        templateUrl: 'html/directive/portalSummaryPage.html',
        scope: {
            summaryData: '=',
            actionfn: '&'
        },
        controller: function($scope, $element, $attrs, $transclude) {
            $scope.isObjProp= function(val){
                var isObj= angular.isObject(val);
                return isObj;
            }
        },
        link: function($scope, element, attrs, controllers){
        }
    };
}]);

/* -----------------TILE-----------------*/

directiveM.directive('tile', function(){
    return {
        restrict: 'E',
        templateUrl: 'html/directive/tile.html',
        scope: {
            tileData: '='
        },
        controller: function($scope, $rootScope, $location){          
            console.log("from controller::: link:::: "+$scope.tileData);            
        },
        link: function($scope, element, attrs, controllers){
            console.log("from directive::: link:::: "+$scope.tileData);
        }
    };
});

/* ---------------------------------------------------COMMON---------------------------------------------------*/

/* -----------------DYNAMIC MODEL-----------------*/

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




