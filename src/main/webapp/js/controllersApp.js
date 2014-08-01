var studentsControllers = angular.module('studentsControllers',['ngTable']);

var FeedbacksCtrl = studentsControllers.controller('FeedbacksCtrl', ['$scope', '$routeParams','feedbacksListFactory','feedbacks','$q','studentsListFactory', function($scope,$routeParams,feedbacksListFactory,feedbacks,$q,studentsListFactory) {

    $scope.reloadList = function (){
        var deferred = $q.defer();
        feedbacksListFactory.getFeedbacksList({studId: $routeParams.studId},function(data) {
            $scope.feedbacks = data;
        });

        deferred.resolve($scope.feedbacks);
    };
   // $scope.reloadList();
    $scope.feedbacks = feedbacks;
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
var StudentListCtrl =  studentsControllers.controller('StudentListCtrl',['$scope','$filter','$routeParams','studentsListFactory', 'ngTableParams','$q','studentsList', function( $scope, $filter,$routeParams, studentsListFactory, ngTableParams, $q,studentsList) {

    $scope.reloadList = function() {
        var deferred = $q.defer();
        studentsListFactory.getStudentsList(function(data){
            $scope.studentsList = data;}
        );
        deferred.resolve($scope.studentsList);
    }
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
StudentListCtrl.studentInfo =
    function(studentsListFactory,$q) {
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