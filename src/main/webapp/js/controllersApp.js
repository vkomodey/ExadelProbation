var studentsControllers = angular.module('studentsControllers',['ngTable']);

var FeedbacksCtrl = studentsControllers.controller('FeedbacksCtrl', [
    '$scope', '$routeParams','feedbacksListFactory','$q','studentsListFactory','$interval','student',
    function($scope,$routeParams,feedbacksListFactory,$q,studentsListFactory,$interval,student) {

    $scope.reloadList = function (){
        var deferred = $q.defer();
        feedbacksListFactory.getFeedbacksList({studId: $routeParams.studId},function(data) {
            $scope.feedbacks = data;
        });

        deferred.resolve($scope.feedbacks);

    };
   // $scope.reloadList();
    $interval(function() {
        $scope.reloadList();
    },5000);

    $scope.feedbacks = student.feedbacks;
    $scope.studentInfo = student.info;
        if($scope.feedbacks == null) {
            $scope.cssFeedbacksList='feedbacksList-hide';
        }
   // $scope.studentInfo = studentInfo;
   /*var emptyExam = {
        grade: null,
        summer: true,
        course: null
    };*/
   // $scope.exams = $scope.studentInfo.study.exams,
  /*  $scope.examsParams = new ngTableParams({
        page: 1,            // show first page
        count: $scope.studentInfo.study.exams.length,          // count per page
        filter: {
            fio: ''     // initial filter

        },
        sorting: {
            fio: 'asc'     // initial sorting
        }
    }, {
        total: $scope.studentInfo.study.exams.length, // length of data
        getData: function ($defer, params) {
            $scope.reloadList();
            var data = $scope.studentsList;
            $defer.resolve(data.slice());
        }, $scope: { studentsList: {} }
    });
    $scope.addExam = function(){
        $scope.studentInfo.study.exams.push(emptyExam);
    }*/

}]);
var StudentListCtrl =  studentsControllers.controller('StudentListCtrl',[
    '$scope','$filter','$routeParams','studentsListFactory', 'ngTableParams','$q','studentsList','$interval',
    function( $scope, $filter,$routeParams, studentsListFactory, ngTableParams, $q,studentsList,$interval) {
    //var studentList;
   $scope.reloadList = function() {
        var deferred = $q.defer();
        studentsListFactory.getStudentsList(function (data) {
                $scope.studentsList = data;
            }
        );
        deferred.resolve($scope.studentsList);
    };
    $interval(function() {
        $scope.reloadList();
    },5000);
    //$scope.reloadList();
    $scope.studentsList = studentsList;
   // var defered = $q.defer();
   // defered.resolve($scope.studentsList);
    //$scope.studentsList = studentsList;
        $scope.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: $scope.studentsList.length+1,          // count per page
            filter: {
                fio: ''     // initial filter

            },
            sorting: {
                fio: 'asc'     // initial sorting
            }
        }, {
            total: $scope.studentsList.length+1, // length of data
            getData: function ($defer, params) {
                $scope.reloadList();
                var data = $scope.studentsList;
                $defer.resolve(data.slice());
            }, $scope: { studentsList: {} }
        });
   // $scope.add = function(){
     //   $scope.tableParams.count( $scope.studentsList.length+1);
  //  }
}]);

studentsControllers.controller('CreateStudentCtrl', ['$scope', '$http', function($scope,$http){
    $scope.createStudent = function() {
        if($scope.login == undefined) {
            alert('field is not filled');
            return;
        }
        var newStudent = {
            login: $scope.login
        };
        $http.post('/rest/stud/create',newStudent)
            .success(function() {
                $scope.PopupCssClass = 'popup-hide';
                $scope.reloadList();
            })
            .error(function(data,status) {
                alert('ERROR '+ status);
            });
    };
}]);

studentsControllers.controller('AddFeedbackCtrl', ['$scope', '$http', '$routeParams', function($scope,$http,$routeParams){
    $scope.addFeedback = function() {
        if($scope.profSuitability == undefined ||
            $scope.attitudeToWork == undefined ||
            $scope.relations == undefined ||
            $scope.progress == undefined) {
            alert("One or several fields are not filled.");
            return;
        }
        var feedback = {
            profSuitability: $scope.profSuitability,
            attitudeToWork: $scope.attitudeToWork,
            relations: $scope.relations,
            progress: $scope.progress,
            increaseHours: $scope.increaseHours,
            workInProject: $scope.workInProject,
            prospect: $scope.prospect,
            other: $scope.other
        }
        $http.post('/rest/stud/'+$routeParams.studId +'/feedbacks/push',feedback)
            .success(function() {
                $scope.PopupCssClass = 'popup-hide';
                $scope.reloadList();
            })
            .error(function(data,status) {
                alert('ERROR '+ status);
            });
    };
}])

StudentListCtrl.studentsList =
    function(studentsListFactory,$q) {
    var deferred = $q.defer();
    studentsListFactory.getStudentsList(function(data){
            deferred.resolve(data);}
    );
    return deferred.promise;
}
FeedbacksCtrl.feedbacks = function(feedbacksListFactory,$q,$route) {
    var deferred = $q.defer();
    feedbacksListFactory.getFeedbacksList({studId: $route.current.params.studId},function(data){
            deferred.resolve(data);}
    );
    return deferred.promise;
}
StudentListCtrl.student =
    function(studentsListFactory,$q,$route) {
        var deferred = $q.defer();
        studentsListFactory.getStudent({studId: $route.current.params.studId},function(data){
                deferred.resolve(data);}
        );
        return deferred.promise;
    }
var EmployeeListCtrl = studentsControllers.controller('EmployeeListCtrl', ['$scope', '$routeParams','employeesList','employees','$q', function($scope,$routeParams,employeesList,employees,$q) {

    $scope.reloadList = function (){
        var deferred = $q.defer();
        employeesList.getEmployeeList({employeeId: $routeParams.employeeId},function(data) {
            $scope.employees = data;
        });
        deferred.resolve($scope.employees);
    };
    // $scope.reloadList();
    $scope.employees = employees;


}]);
EmployeeListCtrl.employees = function(employeesList,$q,$route) {
    var deferred = $q.defer();
    employeesList.getEmployeeList({employeeId: $route.current.params.employeeId},function(data){
            deferred.resolve(data);}
    );
    return deferred.promise;
}

var StudentInfoCtrl = studentsControllers.controller('StudentInfoCtrl',['$scope','$routeParams','$q','$http',function($scope,$routeParams,$q,$http) {
    /*var getStudentInfo = function () {
        var deferred = $q.defer();
        $http.get('../json/studentInfo.json').success(function(data){
            $scope.studentInfo = data;
        });
        deferred.resolve($scope.studentInfo);
    };*/
    if ($scope.studentInfo == null) {
        $scope.cssStudentInfo = 'studentInfo-hide';
    }
    else {
        StudentInfoCtrl.getSkillSet($scope, $http, $q);
        $scope.addExam = function () {
            StudentInfoCtrl.addExam($scope);

        };
        $scope.sendStudentInfo = function () {
            StudentInfoCtrl.sendStudentInfo($scope, $http);
        };
        $scope.addSkill = function () {
            StudentInfoCtrl.addSkill($scope);
        };
        $scope.deleteSkill = function () {
            StudentInfoCtrl.deleteSkill($scope);
        };
        $scope.deleteExam = function () {
            StudentInfoCtrl.deleteExam($scope);
        };
    }
}]);

/*StudentInfoCtrl.getStudentInfo = function ($scope,$http,$q,adress) {
    var deferred = $q.defer();
    $http.get(adress).success(function(data){
        $scope.studentInfo = data;
    });
    deferred.resolve($scope.studentInfo);
};*/
StudentInfoCtrl.studentInfo = function ($q,$http) {
    var deferred = $q.defer();
    $http.get('../json/studentInfo.json').success(function (data) {
        deferred.resolve(data);
    });
    return deferred.promise;
}
StudentInfoCtrl.getSkillSet = function($scope,$http,$q) {
    var deferred = $q.defer();
    $http.get('/rest/types/skill/get').success(function(data){
        $scope.skillTypes = data;
    });
    deferred.resolve($scope.skillTypes);
};
StudentInfoCtrl.addExam = function($scope){
    $scope.studentInfo.study.exams.push({
        grade: null,
        summer: true,
        course: null
    });
}
StudentInfoCtrl.sendStudentInfo = function($scope,$http) {
    $http.post('/rest/stud/'+$scope.studentInfo.id+'/edit',$scope.studentInfo)
        .success(function(){
            alert('the info is sent');
        })
        .error(function(data,status){
            alert('Error: '+status);
        });
};
StudentInfoCtrl.addSkill = function($scope) {
    $scope.studentInfo.skillSet.push( {
        level: null,
        id: 0,
        type: null
    })
};
StudentInfoCtrl.deleteSkill = function($scope,index) {
    $scope.studentInfo.skillSet.splice(index,1);
};
StudentInfoCtrl.deleteExam = function($scope,index) {
    $scope.studentInfo.study.exams.splice(index,1);
};

studentsControllers.controller('CuratorsStudentsCtrl', ['$scope', '$routeParams','curStudentsListFactory','$q', function($scope,$routeParams,curStudentsListFactory,$q) {

   $scope.reloadList = function (){
        var deferred = $q.defer();
        curStudentsListFactory.getCuratorsStudents({curId: $routeParams.curId},function(data) {
            $scope.curStudents = data;
        });
        deferred.resolve($scope.curStudents);
    };

    $scope.fillList= function() {
        $scope.PopupCssClass = 'popup-show';
        $scope.reloadList();
    }

}]);
studentsControllers.controller('CuratorsStudentsCtrl', ['$scope', '$routeParams','curStudentsListFactory','$q', function($scope,$routeParams,curStudentsListFactory,$q) {

    $scope.reloadList = function (){
        var deferred = $q.defer();
        curStudentsListFactory.getCuratorsStudents({curId: $routeParams.curId},function(data) {
            $scope.curStudents = data;
        });
        deferred.resolve($scope.curStudents);
    };

    $scope.fillList= function() {
        $scope.PopupCssClass = 'popup-show';
        $scope.reloadList();
    }

}]);
studentsControllers.controller('testSend', ['$scope', '$http', function($scope,$http){
    var mas=[{"id":19}, {"id":20}];
    $scope.masJson = angular.toJson(mas);
    $scope.testSendF = function() {
        $http.get('/rest/downloadExcel?ids='+masJson)
            .success(function(data) {
                $scope.data = data;
                alert("success");
                console.log(data);

            })
            .error(function(data,status) {
                alert('ERROR '+ status);
            });
    };

    $scope.testSendPdf = function() {
        $http.get('/rest/downloadPDF?ids='+masJson)
            .success(function() {
                alert("success");
            })
            .error(function(data,status) {
                alert('ERROR '+ status);
            });
    };
}])
