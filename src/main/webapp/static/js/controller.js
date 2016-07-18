var controllersM= angular.module('controllersM', ['servicesM']);

//------------------------------------CoreController

controllersM.controller('CoreController', ['$scope', '$http','$location','$rootScope', function($scope, $http, $location, $rootScope){
    /*
    $scope.absUrlCore = $location.absUrl();
    $scope.urlCore = $location.url();
    $scope.protocolCore = $location.protocol();
    $scope.hostCore = $location.host();
    $scope.portCore = $location.port();
    $scope.searchObjectCore = $location.search();
    $scope.hashCore = $location.hash();
    */
    $scope.bannerdata= {};
    $scope.currentUser;
    $rootScope.$on("$locationChangeSuccess", function(event, newUrl, oldUrl, newState, oldState){ 
        var xTabName= $location.path().split("/")[1];
        if(xTabName == 'home'){
            $scope.showHome= true;
        }else{
            $scope.showHome= false;
        }
    });

    /* 
    $http.get('data/json/tileData.json').then(function(response){
        $scope.tileData= response.data;
        console.log($scope.tileData);
    }, function(response){
        alert('something wrong with: data/json/tileData.json');
    });
    */
}]);

//------------------------------------Banner

controllersM.controller('BannerController', ['$scope', '$http', 'PatientService', '$rootScope','$location', function($scope, $http,patientService, $rootScope, $location){
    patientService.core.get({
            action: "getBannerData"
        }, 
        function(response){
            $scope.$parent.bannerdata = response;
        }, 
        function(){ 
            alert('Core getBannerData failed');
        }
    );  
}]);

//------------------------------------Patients

controllersM.controller('PatientsController', ['$scope', '$http', 'PatientService', '$location', function($scope, $http, patientService, $location){ 
    patientService.core.query({
            action: "getPatientColumnData"
        }, 
        function(response){
            $scope.patientGridtData= {};
            $scope.patientGridtData.columnData= response;

            var searchIp= {};
            searchIp.pageNo= 1;
            searchIp.rowsPerPage= 30;
            searchIp.searchData= {};

            $scope.fetchPatients(searchIp); 
        }, 
        function(){ 
            alert('Core getPatientColumnData failed');
        }
    );       
    $scope.editPatient = function(editRow){
        var summaryPath= '/addPatient/'+editRow.basicDetailId;
        $location.path(summaryPath);
        //alert("editPatient");   b
    };
    $scope.viewPatient = function(viewRow){ 
        var summaryPath= '/patientSummary/'+viewRow.basicDetailId;
        $location.path(summaryPath);
        //alert("viewPatient");      
    };
    $scope.deletePatient = function(deleteRow){ 
        alert("Delete not possible");
    };

    $scope.magic = function(deleteRow){ 
        $scope.patientGridtData= {};
    };
    
    $scope.fetchPatients = function(searchIp){
        //return patientService.basicDetail.query({action:"getAll"}); 
        //$scope.patientGridtData.rowData= patientService.basicDetail.query({action:"getAll"});         
        patientService.basicDetail.save({
                action: "getAllBySeach",
                searchIp: searchIp
            }, 
            searchIp, 
            function(response){
                $scope.patientGridtData.rowData= response.responseEntity;
                $scope.patientGridtData.totalRowCount= parseInt(response.responseData.ROW_COUNT);
                $scope.patientGridtData.currentPageNo= parseInt(response.responseData.CURRENT_PAGE_NO);
                $scope.patientGridtData.rowsPerPage= parseInt(response.responseData.ROWS_PER_PAGE);                
                $scope.patientGridtData.pageAry= new Array(parseInt(response.responseData.TOTAL_PAGE_COUNT));                
            },
            function(response){
                alert("Patients getAllBySeach by ip failure");
            }
        );        
    };
}]);

//------------------------------------Add Patient

controllersM.controller('AddPatientController', ['$scope', '$route', '$routeParams', '$location', '$http','PatientService', function($scope, $route, $routeParams, $location, $http, patientService){
    patientService.core.get({
            action: "getPatientWizzardData"
        }, 
        function(response){
            $scope.patientWizzard = response;
            
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
                    alert("Patient get failure");
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
        }, 
        function(){ 
            alert('Core getPatientWizzardData failed');
        }
    );  
 
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
                if(persistedPatientData.responseData && persistedPatientData.responseData.ERROR_MSG){
                    alert(persistedPatientData.responseData.ERROR_MSG);
                }else{
                    $scope.patientDetail= persistedPatientData.responseEntity;
                    //if, its last step, redirect to patient-grid
                    if($scope.isLastStep(patientDataType)){
                        $location.path($scope.$parent.bannerdata.navData.mainNavData.patients.path);
                    }else{
                        //mark current step as complete
                        var currentWizzardStep= $scope.patientWizzard.wizzardStepData[patientDataType];
                        currentWizzardStep.submitted= true;
                        //move to next step in the wizzard
                        $scope.selectWizzardStep($scope.patientWizzard.wizzardStepData[currentWizzardStep.next]);
                    }
                }
            },
            function(){
                alert("Patients save failure");
            }
        );
    };
}]);

//------------------------------------Patient Summary

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
            alert("Patient get failure");
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
        $scope.isEmailTaken= false;
        $scope.isPasswordMatching= true;
        $scope.signUp= function(){
            if($scope.basicDetail.patientPassword != $scope.basicDetail.patientPasswordConfirm){
                //alert("Please match the password");
                $scope.isPasswordMatching= false;
            }else{
                $scope.isPasswordMatching= true;
                //server call: check if email id not already taken      
                patientService.core.save({
                        action: "isEmailIdTaken",
                        emailId: $scope.basicDetail.emailId
                    },{},
                    function(response){
                        if(response && response.isEmailIdTaken){
                            //alert("Email ID already taken!");
                            $scope.isEmailTaken= true;
                        }else{
                            $scope.isEmailTaken= false;
                            //server call: save user
                            patientService.core.save({
                                    action: "signUp"
                                }, 
                                $scope.basicDetail, 
                                function(persistedPatientBasicDetail){
                                   $location.path($scope.$parent.bannerdata.navData.configNavData.signIn.path);
                                }, 
                                function(){
                                    alert("patients save failure");
                                }
                            );
                        }
                    }, 
                    function(){
                        alert("isEmailIdTaken call failed");
                    }
                );
            }
        }
    }
]);

//------------------------------------Home

controllersM.controller('HomeController', ['$scope', '$http', '$route', '$routeParams', '$location','PatientService','PatientGlobleDataService','$window', 
    function($scope, $http, $route, $routeParams, $location, patientService, PatientGlobleDataService, $window){
        //alert($scope.showHome);
        //alert($scope.$parent.showHome);
    /*        
        $http.get('data/json/tileData.json').then(function(response){
            $scope.tileDataNew= response.data;
            console.log($scope.tileDataNew);
        }, function(response){
            alert('something wrong with: data/json/tileData.json');
        });
        */
}]);

//------------------------------------ContactUs


controllersM.controller('ContactUsController', ['$scope', '$http', '$route', '$routeParams', '$location','PatientService','PatientGlobleDataService','$window', 
    function($scope, $http, $route, $routeParams, $location, patientService, PatientGlobleDataService, $window){
        $scope.alerts= [];
        $scope.closeAlert = function(index) {
            $scope.alerts.splice(index, 1);
        };        
        $scope.submitMessage = function(message){ 
            $scope.alerts= [];
            if(message){
                message.name= $scope.$parent.bannerdata.USER_DATA.name;
                message.emailId= $scope.$parent.bannerdata.USER_DATA.emailId;
                patientService.core.save({
                        action: "saveMessage"
                    },
                    message,
                    function(persistedMessage){
                        $scope.message.message= "";
                        $scope.alerts.push({ 
                            type: "success", 
                            msg: "We got your message and shortly will get back to you on it"
                        });
                        //$location.path($scope.$parent.bannerdata.navData.mainNavData.home.path);
                    },
                    function(){
                        alert("Message send failure");
                    }
                );
            }else{
                $scope.alerts.push({
                    type: "danger", 
                    msg: "Please enter the Message."
                });
            }
        };
    }
]);

//------------------------------------Message

controllersM.controller('MessageController', ['$scope', '$http', '$route', '$routeParams', '$location','PatientService','PatientGlobleDataService','$window', 
    function($scope, $http, $route, $routeParams, $location, patientService, PatientGlobleDataService, $window){
        patientService.message.query({
                action: "getMessageColumnData"
            }, 
            function(response){
                $scope.messageGridtData= {};
                $scope.messageGridtData.columnData= response;

                var searchIp= {};
                searchIp.pageNo= 1;
                searchIp.rowsPerPage= 30;
                searchIp.searchData= {};

                $scope.fetchMessages(searchIp); 
            }, 
            function(){ 
                alert('Core getMessageColumnData failed');
            }
        );
        $scope.editPatient = function(editRow){
            var summaryPath = '/messageSummary/'+editRow.id;
            $location.path(summaryPath);
        };
        $scope.viewPatient = function(viewRow){ 
            alert("viewPatient");      
        };
        $scope.deletePatient = function(deleteRow){ 
            alert("delete not possible");
        };
        $scope.fetchMessages = function(searchIp){
            patientService.message.save({
                    action: "getAllBySeach",
                    searchIp: searchIp
                }, 
                searchIp, 
                function(response){
                    $scope.messageGridtData.rowData= response.responseEntity;
                    $scope.messageGridtData.totalRowCount= parseInt(response.responseData.ROW_COUNT);
                    $scope.messageGridtData.currentPageNo= parseInt(response.responseData.CURRENT_PAGE_NO);
                    $scope.messageGridtData.rowsPerPage= parseInt(response.responseData.ROWS_PER_PAGE);                
                    $scope.messageGridtData.pageAry= new Array(parseInt(response.responseData.TOTAL_PAGE_COUNT));                
                },
                function(response){
                    alert("Patients getAllBySeach by ip failure");
                }
            );
        };
    }
]);


controllersM.controller('MessageAnswerController', ['$scope', '$http', '$route', '$routeParams', '$location','PatientService','PatientGlobleDataService','$window', 
    function($scope, $http, $route, $routeParams, $location, patientService, PatientGlobleDataService, $window){
        $scope.messageData= {};
        patientService.message.get({
            action: "getMessageFormData"
        }, function(messageFormResp){
            $scope.messageData= messageFormResp;
            if($routeParams.messageId){
                patientService.message.get({
                    action: "get",
                    messageId: $routeParams.messageId
                }, function(messageResp){
                    $scope.messageData.data= messageResp.responseEntity;
                }, function(){
                    alert("Message get failure");
                });
            }
        }, function(){
            alert("getMessageFormData get failure");
        });

        $scope.answerMessage = function(dataType, data){
            patientService.message.save({
                action: "update"
            }, 
            data,
            function(messageResp){
                 alert("Message answered :)");
            }, function(){
                alert("Message save failure");
            });        
        };
    }
]);