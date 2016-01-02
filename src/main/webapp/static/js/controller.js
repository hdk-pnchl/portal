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

    $rootScope.$on("$locationChangeSuccess", function(event, newUrl, oldUrl, newState, oldState){ 
        console.log("newUrl:" + newUrl); 
        console.log("$location.path:" + $location.path()); 
    });
}]);

//------------------------------------PatientsController

controllersM.controller('PatientsController', ['$scope', '$http','PatientService', '$location', function($scope, $http, patientService, $location){    
    $http.get('data/json/patientColumnData.json').then(function(response){
        $scope.patientGridtData= {};
        $scope.patientGridtData.columnData = response.data;
        $scope.patientGridtData.rowData= patientService.basic.query({action:"getAll"}); 
        //console.log($scope.patientGridtData);
    }, function(response){
        alert('something wrong with: /nowstatic/data/json/patientColumnData.json');
    });
    $scope.editPatient = function(editRow){  
        //alert("editPatient");   
    };
    $scope.viewPatient = function(viewRow){ 
        var summaryPath= '/patientSummary/'+viewRow.id;
        $location.path(summaryPath);      
        //alert("viewPatient");      
    };
    $scope.deletePatient = function(deleteRow){ 
        //alert("deletePatient");        
    };    
}]);

//------------------------------------AddPatientController

controllersM.controller('AddPatientController', ['$scope', '$http','PatientService', '$location', function($scope, $http, $patientService, $location){
    $http.get('data/json/patientWizzard.json').then(function(response){
        $scope.patientWizzard = response.data;
    }); 
 
    $scope.selectWizzardStep= function(selectedWizzardStep){
        if(selectedWizzardStep.name != $scope.patientWizzard.wizzardStepData.basic.name && !$scope.patientWizzard.wizzardStepData.basic.submitted){
            alert("Please enter the basic detail first.");
            return;
        }
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

    $scope.patientData= {};    
    $scope.submitPatientForm = function(patientDataType, patientData){     
        var service= $patientService[patientDataType];
        if(patientDataType != "basic"){
            patientData.patient= $scope.patientData;
        } 
        //server call          
        service.save({
                action: "save",
                patientId: $scope.patientData.id
            }, 
            patientData, 
            function(persistedPatientData){
                if(patientDataType == "basic"){
                    $scope.patientData= persistedPatientData;
                }           
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
        });      
    };
}]);

//------------------------------------PatientSummaryController

controllersM.controller('PatientSummaryController', ['$scope', '$route', '$routeParams', '$location','PatientService','PatientGlobleDataService', function($scope, $route, $routeParams, $location, patientService, PatientGlobleDataService){
    $scope.patientDetail= {};
    if($routeParams.patientId){
         patientService.basic.get({
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


