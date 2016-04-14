var controllersM= angular.module('controllersM', ['servicesM']);

//------------------------------------CoreController

controllersM.controller('CoreController', ['$scope', '$http','$location', function($scope, $http, $location){
    $scope.absUrlCore = $location.absUrl();
    $scope.urlCore = $location.url();
    $scope.protocolCore = $location.protocol();
    $scope.hostCore = $location.host();
    $scope.portCore = $location.port();
    $scope.searchObjectCore = $location.search();
    $scope.hashCore = $location.hash();
}]);

//------------------------------------BannerController

controllersM.controller('BannerController', ['$scope', '$http', '$rootScope','$location', function($scope, $http, $rootScope, $location){
	$http.get('http://localhost:8080/portal/ctrl/core/getBannerData').then(function(response){
    	$scope.bannerdata = response.data;
  	}, function(response){
    	alert('something wrong with: http://localhost:8080/portal/ctrl/core/getBannerData');
  	});
}]);

//------------------------------------PatientsController

controllersM.controller('PatientsController', ['$scope', '$http', 'PatientService', '$location', function($scope, $http, patientService, $location){    
    $http.get('http://localhost:8080/portal/ctrl/core/getPatientColumnData').then(function(response){
        $scope.patientGridtData= {};
        $scope.patientGridtData.columnData = response.data;
        $scope.patientGridtData.rowData= patientService.basicDetail.query({action:"getAll"}); 
    }, function(response){
        alert('something wrong with: http://localhost:8080/portal/ctrl/core/getPatientColumnData');
    });
    $scope.editPatient = function(editRow){
        var summaryPath= '/addPatient/'+editRow.id;
        $location.path(summaryPath);
        //alert("editPatient");   b
    };
    $scope.viewPatient = function(viewRow){ 
        var summaryPath= '/patientSummary/'+viewRow.id;
        $location.path(summaryPath);
        //alert("viewPatient");      
    };
    $scope.deletePatient = function(deleteRow){ 
        alert("delete not possible");
    };
}]);

//------------------------------------AddPatientController

controllersM.controller('AddPatientController', ['$scope', '$route', '$routeParams', '$location', '$http','PatientService', function($scope, $route, $routeParams, $location, $http, patientService){
    $http.get('http://localhost:8080/portal/ctrl/core/getPatientWizzardData').then(function(response){
        $scope.patientWizzard = response.data;
        
        $scope.patientDetail= {};
        if($routeParams.patientId){
             patientService.patient.get({
                action: "getFull",
                patientid: $routeParams.patientId
            }, function(patientDataResp){
                $scope.patientDetail= patientDataResp;
                angular.forEach($scope.patientWizzard.wizzardData, function(formIpData, formName){
                    formIpData.data= $scope.patientDetail[formName];
                });                
            }, function(){
                alert("patient get failure");
            });          
        }else{
            angular.forEach($scope.patientWizzard.wizzardData, function(formIpData, formName){
                $scope.patientDetail[formName]= {};
                angular.forEach(formIpData.fieldAry, function(field){
                    $scope.patientDetail[formName][field.name]= "";
                });   
                formIpData.data= $scope.patientDetail[formName];
            });             
        }
        $scope.patientDetail.isReady= true;
    }); 
 
    $scope.selectWizzardStep= function(selectedWizzardStep){
        /*
        if(selectedWizzardStep.name != $scope.patientWizzard.wizzardStepData.basic.name && !$scope.patientWizzard.wizzardStepData.basic.submitted){
            alert("Please enter the basic detail first.");
            return;
        }
        */
        angular.forEach($scope.patientWizzard.wizzardStepData, function(wizzardStep){
            wizzardStep.active = false;
            wizzardStep.class = '';
        });    
        selectedWizzardStep.active= true;
        selectedWizzardStep.class = 'active';

        angular.forEach($scope.patientWizzard.wizzardData, function(value, key){
            value.isHidden = true;
        });    
        $scope.patientWizzard.wizzardData[selectedWizzardStep.name].isHidden=false;
    };
 
    $scope.isLastStep= function(step) {
       if(step == $scope.patientWizzard.commonData.lastStep){
            return true;
       }
       return false;
    }

    $scope.submitPatientForm = function(patientDataType, patientData){
        var service= patientService[patientDataType];
        var action= "save";
        if($scope.patientDetail[patientDataType] && $scope.patientDetail[patientDataType].id){
            action= "update";
            patientData["id"]= $scope.patientDetail[patientDataType]["id"];
        }
        //server call          
        service.save({
                action: action,
                patientId: $scope.patientDetail.id
            }, 
            patientData, 
            function(persistedPatientData){
                $scope.patientDetail= persistedPatientData;
                //if, its last step, redirect to patient-grid
                if($scope.isLastStep(patientDataType)){
                    $location.path('/patients');
                }else{
                    //mark current step as complete
                    var currentWizzardStep= $scope.patientWizzard.wizzardStepData[patientDataType];
                    currentWizzardStep.submitted= true;
                    //move to next step in the wizzard
                    $scope.selectWizzardStep($scope.patientWizzard.wizzardStepData[currentWizzardStep.next]);
                }
            },
            function(){
                alert("patients save failure");
            }
        );
    };
}]);

//------------------------------------PatientSummaryController

controllersM.controller('PatientSummaryController', ['$scope', '$route', '$routeParams', '$location','PatientService','PatientGlobleDataService', function($scope, $route, $routeParams, $location, patientService, PatientGlobleDataService){
    $scope.patientDetail= {};
    if($routeParams.patientId){
         patientService.patient.get({
            action: "getFull",
            patientid: $routeParams.patientId
        }, function(patientDataResp){
            $scope.patientDetail= patientDataResp;
            PatientGlobleDataService['patientDetail']= patientDataResp;
        }, function(){
            alert("patient get failure");
        });
    } else{
        $scope.patientDetail= PatientGlobleDataService['patientDetail'];
    }
}]);

//------------------------------------SignIN

controllersM.controller('SignInController', ['$scope', '$route', '$routeParams', '$location','PatientService','PatientGlobleDataService', function($scope, $route, $routeParams, $location, patientService, PatientGlobleDataService){
    $scope.signIp= function(){
    }
}]);

//------------------------------------SignUP

controllersM.controller('SignUpController', ['$scope', '$route', '$routeParams', '$location','PatientService','PatientGlobleDataService','$window', 
    function($scope, $route, $routeParams, $location, patientService, PatientGlobleDataService, $window){
        $scope.signUp= function(){
            if($scope.basicDetail.patientPassword != $scope.basicDetail.patientPasswordConfirm){
                alert("Please match the password");
            }else{
                //server call          
                patientService.core.save({
                        action: "signUp"
                    }, 
                    $scope.basicDetail, 
                    function(persistedPatientBasicDetail){
                       $location.path('/signIn');
                    }, 
                    function(){
                        alert("patients save failure");
                    }
                );
            }
        }
    }
]);

//------------------------------------SignOut

controllersM.controller('SignOutController', ['$scope', '$route', '$routeParams', '$location','PatientService','PatientGlobleDataService','$window', 
    function($scope, $route, $routeParams, $location, patientService, PatientGlobleDataService, $window){
    $window.location.href="/portal/logout";
}]);

//------------------------------------Home

controllersM.controller('HomeController', ['$scope', '$route', '$routeParams', '$location','PatientService','PatientGlobleDataService','$window', 
    function($scope, $route, $routeParams, $location, patientService, PatientGlobleDataService, $window){
    //$window.location.href="/portal/logout";
}]);


/*
patientService.get({action:"test"},function(){
    alert("test success");
},function(){
    alert("failure");
});

patientService.query({action:"save"},{
    age: 232,
    basic: "fdf",
    education: "fdf",
    emailId: "sdsd@dd.com",
    isMarried: "true",
    occupation: "sdsd",
    regNo: 334
},function(){
    alert("save success");
},function(){
    alert("save failure");
});  
*/ 


