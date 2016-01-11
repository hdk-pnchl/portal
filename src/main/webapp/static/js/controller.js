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
	$http.get('data/json/bannerData.json').then(function(response){
    	$scope.bannerdata = response.data;
  	}, function(response){
    	alert('something wrong with: /nowstatic/data/json/bannerData.json');
  	});	    
}]);

//------------------------------------PatientsController

controllersM.controller('PatientsController', ['$scope', '$http','PatientService', '$location', function($scope, $http, patientService, $location){    
    $http.get('data/json/patientColumnData.json').then(function(response){
        $scope.patientGridtData= {};
        $scope.patientGridtData.columnData = response.data;
        $scope.patientGridtData.rowData= patientService.basicDetail.query({action:"getAll"}); 
    }, function(response){
        alert('something wrong with: /nowstatic/data/json/patientColumnData.json');
    });
    $scope.editPatient = function(editRow){  
        var summaryPath= '/addPatient/'+editRow.id;
        $location.path(summaryPath);  
        //alert("editPatient");   
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
    $http.get('data/json/patientWizzard.json').then(function(response){
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

    $scope.submitPatientForm = function(patientDataType, patientData){     
        var service= patientService[patientDataType];
        //server call          
        service.save({
                action: "save",
                patientId: $scope.patientDetail.id
            }, 
            patientData, 
            function(persistedPatientData){
                $scope.patientDetail= persistedPatientData;
                $scope.patientDetail[patientDataType]= persistedPatientData;
                //if, its last step, redirect to patient-grid
                if(patientDataType == "interrogate"){
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


