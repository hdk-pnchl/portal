var portalM= angular.module('portalM', ['ngRoute', 'controllersM', 'servicesM', 'directiveM']);

portalM.config(function($resourceProvider) {
  	//$resourceProvider.defaults.stripTrailingSlashes = false;
});

portalM.config(['$routeProvider',function($routeProvider){
	$routeProvider.when('/patients', {
		templateUrl: 'html/patients.html',
		controller: 'PatientsController'
	});
	$routeProvider.when('/addPatient', {
		templateUrl: 'html/addPatient.html',
		controller: 'AddPatientController'
	});
	$routeProvider.when('/patientSummary', {
		templateUrl: 'html/patientSummary.html',
		controller: 'PatientSummaryController'
	});	
	$routeProvider.when('/patientSummary/:patientId', {
		templateUrl: 'html/patientSummary.html',
		controller: 'PatientSummaryController'
	});
	
	$routeProvider.otherwise({
        redirectTo: '/patients'
	});
}]);
