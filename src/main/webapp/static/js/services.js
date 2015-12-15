var serviceM= angular.module('servicesM', ['ngResource']);

serviceM.factory('PatientService', ['$resource', function($resource){
    //$resource(url, [paramDefaults], [actions], options);
    //portal/ctrl/patient/test
    return $resource('/portal/ctrl/patients/:patienAction',{
        patienAction: '@patienAction'
    });
}])