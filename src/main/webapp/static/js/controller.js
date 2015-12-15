var controllersM= angular.module('controllersM', ['servicesM']);

//------------------------------------CoreController

controllersM.controller('CoreController', ['$scope', '$http', function($scope, $http){
}]);

//------------------------------------BannerController

controllersM.controller('BannerController', ['$scope', '$http', function($scope, $http){
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
        $scope.patientGridtData.rowData= patientService.query({patienAction:"getAll"}); 
        //console.log($scope.patientGridtData);
    }, function(response){
        alert('something wrong with: /nowstatic/data/json/patientColumnData.json');
    });
    $scope.editPatient = function(editRow){  
        var summaryPath= '/patientSummary/'+editRow.id;
        $location.path(summaryPath);
        //alert("editPatient");   
    };
    $scope.viewPatient = function(viewRow){   
        //alert("viewPatient");      
    };
    $scope.deletePatient = function(deleteRow){ 
        //alert("deletePatient");        
    };    
}]);

//------------------------------------AddPatientController

controllersM.controller('AddPatientController', ['$scope', '$http','PatientService', '$location', function($scope, $http, patientService, $location){
    $http.get('data/json/patientWizzard.json').then(function(response){
        $scope.patientWizzard = response.data;
    }); 
 
    $scope.selectWizzardStep= function(selectedWizzardStep){
        angular.forEach($scope.patientWizzard.wizzardStepAry, function(wizzardStep){
            wizzardStep.active = false;
        });    
        selectedWizzardStep.active= true;

        angular.forEach($scope.patientWizzard.wizzardData, function(value, key){
            value.isHidden = true;
        });    
        $scope.patientWizzard.wizzardData[selectedWizzardStep.name].isHidden=false;
    };
    
    $scope.submitPatientForm = function(patientDataType, patientData){        
        //console.log(patientDataType);
        //console.log(patientData);
        
        patientService.save({patienAction:"save"}, patientData, function(){
            $location.path('/patients')
        },function(){
            alert("patients save failure");
        });          
    };
}]);

//------------------------------------PatientSummaryController

controllersM.controller('PatientSummaryController', ['$scope', '$route', '$routeParams', '$location','PatientService', function($scope, $route, $routeParams, $location, patientService){
    $scope.route= $route;
    $scope.location= $location;
    $scope.routeParams= $routeParams;
    
    $scope.patientDetail= {};

    if($scope.routeParams.patientId){
         patientService.get({
            patienAction: "getFull",
            patientid: $scope.routeParams.patientId
        }, function(patientDataResp){
            $scope.patientDetail= patientDataResp;
        }, function(){
            alert("patient get failure");
        });          
    }
}]);

/*
patientService.get({patienAction:"test"},function(){
    alert("test success");
},function(){
    alert("failure");
});

patientService.query({patienAction:"save"},{
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


