var studentsControllers = angular.module('studentsControllers',['ngTable']);

studentsControllers.controller('FeedbacksCtrl', ['$scope', '$routeParams','feedbacksList', function($scope,$routeParams,feedbacksList) {

    $scope.reloadList = function (){

        $scope.feedbacks = feedbacksList.getFeedbacksList({studId: $routeParams.studId});
    };
    $scope.reloadList();
}]);

studentsControllers.controller('StudentListCtrl',['$scope','$filter','$routeParams','studentsList', 'ngTableParams','$q', function( $scope, $filter,$routeParams, studentsList, ngTableParams, $q) {

    $scope.reloadList = function() {
        var defered = $q.defer();
        studentsList.getStudentsList(function(data){
            $scope.students = data;}
        );
        defered.resolve($scope.students);
    }
    $scope.reloadList();
   // var defered = $q.defer();
   // defered.resolve($scope.students);
    /*$scope.students = students;
        $scope.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: $scope.students.length,          // count per page
            filter: {
                fio: ''     // initial filter

            },
            sorting: {
                fio: 'asc'     // initial sorting
            }
        }, {
            total: $scope.students.length, // length of data
            getData: function ($defer, params) {
                $scope.reloadList()
                var data = $scope.students;
                $defer.resolve(data.slice());
            }, $scope: { students: {} }
        });*/
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