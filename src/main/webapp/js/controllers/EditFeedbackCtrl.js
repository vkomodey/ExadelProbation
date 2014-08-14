/**
 * Created by Administrator on 14.08.2014.
 */
studentsControllers.controller('EditFeedbackCtrl',['$scope','$http',function($scope,$http){
    $scope.editFeedback = function() {
        $http.post('/rest/stud/'+$scope.studentInfo.id+'/feedback/'+$scope.feedbackEdit.id+'/edit',$scope.feedbackEdit)
            .success(function(){
                $scope.reloadList();
            })
            .error(function(data,status){
                alert('ERROR ' + status);
            })
    }
}]);