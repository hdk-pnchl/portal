var portalM= angular.module('portalM', ['ngRoute', 'controllersM', 'servicesM', 'directiveM']);

portalM.config(function($resourceProvider) {
  	//$resourceProvider.defaults.stripTrailingSlashes = false;
});

portalM.config(['$routeProvider',function($routeProvider){
	//all patients
	$routeProvider.when('/patients', {
		templateUrl: 'html/patients.html',
		controller: 'PatientsController'
	});
	
	//add patient
	$routeProvider.when('/addPatient', {
		templateUrl: 'html/addPatient.html',
		controller: 'AddPatientController'
	});
	$routeProvider.when('/addPatient/:patientId', {
		templateUrl: 'html/addPatient.html',
		controller: 'AddPatientController'
	});

	//patient summary
	$routeProvider.when('/patientSummary', {
		templateUrl: 'html/patientSummary.html',
		controller: 'PatientSummaryController'
	});	
	$routeProvider.when('/patientSummary/:patientId', {
		templateUrl: 'html/patientSummary.html',
		controller: 'PatientSummaryController'
	});
	
	//signIn
	$routeProvider.when('/signIn', {
		templateUrl: 'html/core/signIn.html',
		controller: 'SignInController'
	});
	//signUp	
	$routeProvider.when('/signUp', {
		templateUrl: 'html/core/signUp.html',
		controller: 'SignUpController'
	});

	//Home
	$routeProvider.when('/home', {
		//templateUrl: 'html/core/processing.html',
		templateUrl: 'html/core/home.html',
		controller: 'HomeController'
	});

	//otherwise
	$routeProvider.otherwise({
        redirectTo: '/home'
	});
}]);

portalM.config(['$locationProvider', function($locationProvider){
	//$locationProvider.html5Mode({ enabled: true });	
	// $locationProvider.html5Mode(true);
}]);


