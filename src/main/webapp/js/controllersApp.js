var studentsControllers = angular.module('studentsControllers',['ngTable']);

var FeedbacksCtrl = studentsControllers.controller('FeedbacksCtrl', ['$scope', '$routeParams','feedbacksList','feedbacks','$q', function($scope,$routeParams,feedbacksList,feedbacks,$q) {

    $scope.reloadList = function (){
        var deferred = $q.defer();
        feedbacksList.getFeedbacksList({studId: $routeParams.studId},function(data) {
            $scope.feedbacks = data;
        });
        deferred.resolve($scope.feedbacks);
    };
   // $scope.reloadList();
    $scope.feedbacks = feedbacks;

}]);
var StudentListCtrl =  studentsControllers.controller('StudentListCtrl',['$scope','$filter','$routeParams','studentsList', 'ngTableParams','$q','students', function( $scope, $filter,$routeParams, studentsList, ngTableParams, $q,students) {

    $scope.reloadList = function() {
        var deferred = $q.defer();
        studentsList.getStudentsList(function(data){
            $scope.students = data;}
        );
        deferred.resolve($scope.students);
    }
    //$scope.reloadList();
    $scope.students = students;
   // var defered = $q.defer();
   // defered.resolve($scope.students);
    //$scope.students = students;
        $scope.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: $scope.students.length,          // count per page
            filter: {
                surname: ''     // initial filter

            },
            sorting: {
                surname: 'asc'     // initial sorting
            }
        }, {
            total: $scope.students.length, // length of data
            getData: function ($defer, params) {
                $scope.reloadList()
                var data = $scope.students;
                $defer.resolve(data.slice());
            }, $scope: { students: {} }
        });
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
            $scope.progress == undefined ||
            $scope.other == undefined) {
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

StudentListCtrl.students =
    function(studentsList,$q) {
    var deferred = $q.defer();
    studentsList.getStudentsList(function(data){
            deferred.resolve(data);}
    );
    return deferred.promise;
}
FeedbacksCtrl.feedbacks = function(feedbacksList,$q,$route) {
    var deferred = $q.defer();
    feedbacksList.getFeedbacksList({studId: $route.current.params.studId},function(data){
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