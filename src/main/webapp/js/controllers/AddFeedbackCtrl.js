/**
 * Created by Administrator on 04.08.2014.
 */
studentsControllers.controller('AddFeedbackCtrl', ['$scope', '$http', '$routeParams', function($scope,$http,$routeParams){
    $scope.addFeedback = function() {
        var feedback = {
            profSuitability: $scope.profSuitability,
            attitudeToWork: $scope.attitudeToWork,
            relations: $scope.relations,
            progress: $scope.progress,
            increaseHours: $scope.increaseHours,
            workInProject: $scope.workInProject,
            prospect: $scope.prospect,
            other: $scope.other
        };
        $http.post('/rest/stud/'+$routeParams.studId +'/feedbacks/push',feedback)
            .success(function() {
                $scope.reloadList();
            })
            .error(function(data,status) {
                alert('ERROR '+ status);
            });
    };
}])
