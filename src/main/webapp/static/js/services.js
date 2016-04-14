var serviceM= angular.module('servicesM', ['ngResource']);

serviceM.factory('PatientService', ['$resource', function($resource){
    //$resource(url, [paramDefaults], [actions], options);
    //portal/ctrl/patient/test
    var patientResouce= {};

    patientResouce.patient= $resource('/portal/ctrl/patients/patient/:action',{
        action: '@action'
    });

    patientResouce.basicDetail= $resource('/portal/ctrl/patients/basicDetail/:action',{
        action: '@action'
    });

    patientResouce.address= $resource('/portal/ctrl/patients/address/:action',{
        action: '@action'
    });

    patientResouce.family= $resource('/portal/ctrl/patients/family/:action',{
        action: '@action'
    });

    patientResouce.observation= $resource('/portal/ctrl/patients/observation/:action',{
        action: '@action'
    });

    patientResouce.interrogate= $resource('/portal/ctrl/patients/interrogate/:action',{
        action: '@action'
    });

    patientResouce.core= $resource('/portal/ctrl/core/:action',{
        action: '@action'
    });

    return patientResouce;
}])

serviceM.factory('PatientGlobleDataService', ['$resource', function($resource){
    var patientGlobleDataService= {};
    return patientGlobleDataService;
}])