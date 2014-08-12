var StudentListCtrl = studentsControllers.controller('StudentListCtrl', [
    '$scope', '$filter', '$routeParams', 'studentsListFactory', 'CuratorsListFactory','LogListFactory', 'filterParamsFactory', 'ngTableParams', '$q', 'studentsList', '$interval', '$http',
    function ($scope, $filter, $routeParams, studentsListFactory, CuratorsListFactory,LogListFactory, filterParamsFactory, ngTableParams, $q, studentsList, $interval, $http) {


        $scope.reloadList = function() {
            var deferred = $q.defer();
            $scope.checkedStudArray = [];
            studentsListFactory.getStudentsList(function (data) {
                    $scope.studentsList = data;
                }
            );
            deferred.resolve($scope.studentsList);
        };
        /*$interval(function() {
         $scope.reloadList();
         },60000);*/
        $scope.studIdForLog = null;
        $scope.saveIdForLog = function(id){
          $scope.studIdForLog = id;
        };
        $scope.checkedStudArray = [];
        $scope.checkElement = function (id) {
            StudentListCtrl.checkElement(id, $scope.checkedStudArray);
        };
        $scope.studentsList = studentsList;
        $scope.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: $scope.studentsList.length + 1,          // count per page
            filter: {
                fio: ''     // initial filter

            },
            sorting: {
                surname: 'asc'     // initial sorting
            }
        }, {
            total: $scope.studentsList.length + 1, // length of data
            getData: function ($defer, params) {
                $scope.reloadList();
                var data = $scope.studentsList;
                $defer.resolve(data.slice());
            }, $scope: { studentsList: {} }
        });
        /*$scope.toJsonStudentCheckedArray = function () {
            if ($scope.checkedStudArray.length != 0) {
                var arrayForPdfOrExcel = [];
                $scope.checkedStudArray.forEach(function (element, index, array) {
                    arrayForPdfOrExcel.push({
                        id: element
                    });
                });
                return angular.toJson(arrayForPdfOrExcel);
            }
        };*/
        $scope.reloadCuratorsList = function () {
            var deferred = $q.defer();
            $scope.checkedCuratorArray = [];
            CuratorsListFactory.getCuratorsList(function (data) {
                $scope.curatorsList = data;
            });
            deferred.resolve($scope.curatorsList);
        };
        $scope.checkAllStudent = function(){

        };
        /////////////////////////////////////////////////////////////////////////////////////// LERA STYLE NEXT  ///////////////////////////////////////////////////
        ($scope.reloadFilterParams = function() {
           filterParamsFactory.getFilterParams(function (data) {
               $scope.filterParams = data;


               $scope.filterOptions = {
                   courses: [
                       {   name: 'Show All'},
                       {   name: '2 course'},
                       {   name: '3 course'},
                       {   name: '4 course'},
                       {   name: '5 course'},
                       {   name: '6 course'}
                   ],
                   englishlevels: [
                       {   name: 'Show All'},
                       {   name: 'beginner'},
                       {   name: 'elementary'},
                       {   name: 'preintermediate'},
                       {   name: 'intermediate'},
                       {   name: 'upperintermediate'},
                       {   name: 'advanced'}
                   ],
                   workinghours: [
                       {name: 'Show All'},
                       {name: '20 hours'},
                       {name: '30 hours'},
                       {name: '40 hours'}
                   ],
                   salaries: [
                       {name: 'Show All', state: 2},
                       {name: 'billable', state: true},
                       {name: 'not billable', state: false}
                   ]
               };
               $scope.filterItem = {
                   /////inner
                   course: $scope.filterOptions.courses[0],
                   workinghour: $scope.filterOptions.workinghours[0],
                   englishlevel: $scope.filterOptions.englishlevels[0],
                   salary: $scope.filterOptions.salaries[0],
                   // from factory
                   skillname: $scope.filterParams.skillnames[$scope.filterParams.skillnames.length - 1],
                   skillname2: $scope.filterParams.skillnames[$scope.filterParams.skillnames.length - 1],
                   skillname3: $scope.filterParams.skillnames[$scope.filterParams.skillnames.length - 1],
                   faculty: $scope.filterParams.faculties[$scope.filterParams.faculties.length - 1],
                   university: $scope.filterParams.universities[$scope.filterParams.universities.length - 1],
                   study_end_year: $scope.filterParams.study_end_years[$scope.filterParams.study_end_years.length - 1],
                   curator: $scope.filterParams.curators[$scope.filterParams.curators.length - 1]
               };

               $scope.customFilterEnglish = function (studentsList) {
                   if (studentsList.english === null && $scope.filterItem.englishlevel.name !== 'Show All') {
                       return false;
                   } else {
                       if (studentsList.english === null && $scope.filterItem.englishlevel.name === 'Show All') {
                           return true;
                       } else {
                           if (studentsList.english === $scope.filterItem.englishlevel.name) {
                               return true;
                           } else if ($scope.filterItem.englishlevel.name === 'Show All') {
                               return true;
                           } else {
                               return false;
                           }
                       }
                   }

               };
               $scope.customFilterCourse = function (studentsList) {
                   if (studentsList.study.course_group === null && $scope.filterItem.course.name !== 'Show All') {
                       return false;
                   } else {
                       if (studentsList.study.course_group === null && $scope.filterItem.course.name === 'Show All') {
                           return true;
                       } else {
                           if (studentsList.study.course_group[0] === $scope.filterItem.course.name[0]) {
                               return true;
                           } else if ($scope.filterItem.course.name === 'Show All') {
                               return true;
                           } else {
                               return false;
                           }
                       }
                   }

               };
               $scope.customFilterHours = function (studentsList) {
                   if (studentsList.hours_current === null && $scope.filterItem.workinghour.name !== 'Show All') {
                       return false;
                   } else {
                       if (studentsList.hours_current === null && $scope.filterItem.workinghour.name === 'Show All') {
                           return true;
                       } else {

                           if (studentsList.hours_current.toString().charAt(0) === $scope.filterItem.workinghour.name.charAt(0)) {
                               return true;
                           } else if ($scope.filterItem.workinghour.name === 'Show All') {
                               return true;
                           } else {
                               return false;
                           }
                       }
                   }

               };
               $scope.customFilterSalary = function (studentsList) {

                   if (studentsList.isBillable === null) {
                       if ($scope.filterItem.salary.state === true) {
                           return false;
                       } else {
                           return true;
                       }
                   } else {
                       if (studentsList.isBillable === $scope.filterItem.salary.state) {
                           return true;
                       } else if ($scope.filterItem.salary.name === 'Show All') {
                           return true;
                       } else {
                           return false;
                       }
                   }


               };
               $scope.customFilterTech = function (studentsList) {
                   var j;
                   if(studentsList.skillSet.length ===0){
                       if($scope.filterItem.skillname.name === 'Show All'){
                           return true;
                       }else {
                           return false;
                       }
                   }else{
                       if($scope.filterItem.skillname.name === 'Show All'){
                           return true;
                       }else{
                           if($scope.filterItem.skillname.name !== 'Show All'){
                               for (j = 0; j < studentsList.skillSet.length;) {
                                   if (studentsList.skillSet.length !== 0) {
                                       if (studentsList.skillSet[j].type.name === $scope.filterItem.skillname.name) {
                                           return true;
                                       } else {
                                           j++;
                                       }
                                   } else {
                                       return false;
                                   }
                               }
                           }
                       }}
               };
               $scope.customFilterTech2 = function (studentsList) {
                   var k;
                   if(studentsList.skillSet.length ===0){
                       if($scope.filterItem.skillname2.name === 'Show All'){
                           return true;
                       }else {
                           return false;
                       }
                   }else{
                       if($scope.filterItem.skillname2.name === 'Show All'){
                           return true;
                       }else{
                           if($scope.filterItem.skillname2.name !== 'Show All'){
                               for (k = 0; k < studentsList.skillSet.length;) {
                                   if (studentsList.skillSet.length !== 0) {
                                       if (studentsList.skillSet[k].type.name === $scope.filterItem.skillname2.name) {
                                           return true;
                                       } else {
                                           k++;
                                       }
                                   } else {
                                       return false;
                                   }
                               }
                           }
                       }}
               };
               $scope.customFilterTech3 = function (studentsList) {
                   var m;
                   if(studentsList.skillSet.length ===0){
                       if($scope.filterItem.skillname3.name === 'Show All'){
                           return true;
                       }else {
                           return false;
                       }
                   }else{
                       if($scope.filterItem.skillname3.name === 'Show All'){
                           return true;
                       }else{
                           if($scope.filterItem.skillname3.name !== 'Show All'){
                               for (m = 0; m < studentsList.skillSet.length;) {
                                   if (studentsList.skillSet.length !== 0) {
                                       if (studentsList.skillSet[m].type.name === $scope.filterItem.skillname3.name) {
                                           return true;
                                       } else {
                                           m++;
                                       }
                                   } else {
                                       return false;
                                   }
                               }
                           }
                       }}
               };
               $scope.customFilterFaculty = function (studentsList) {
                   if (studentsList.study.faculty === null && $scope.filterItem.faculty.name === 'Show All') {
                       return true;
                   } else {
                       if (studentsList.study.faculty === null && $scope.filterItem.faculty.name !== '') {
                           return false;
                       } else {
                           if (studentsList.study.faculty === null && $scope.filterItem.faculty.name === '') {
                               return true;
                           } else {
                               if (studentsList.study.faculty.toString() === $scope.filterItem.faculty.name) {
                                   return true;
                               } else if ($scope.filterItem.faculty.name === 'Show All') {
                                   return true;
                               } else {
                                   return false;
                               }
                           }
                       }
                   }
               };
               $scope.customFilterUniversity = function (studentsList) {
                   if (studentsList.study.university === null && $scope.filterItem.university.name === 'Show All') {
                       return true;
                   } else {
                       if (studentsList.study.university === null && $scope.filterItem.university.name !== '') {
                           return false;
                       } else {
                           if (studentsList.study.university === null && $scope.filterItem.university.name === '') {
                               return true;
                           } else {
                               if (studentsList.study.university.toString() === $scope.filterItem.university.name) {
                                   return true;
                               } else if ($scope.filterItem.university.name === 'Show All') {
                                   return true;
                               } else {
                                   return false;
                               }
                           }
                       }
                   }
               };
               $scope.customFilterGraduate = function (studentsList) {
                   if (studentsList.study.graduate_year === null && $scope.filterItem.study_end_year.name === 'Show All') {
                       return true;
                   } else {
                       if (studentsList.study.graduate_year === null && $scope.filterItem.study_end_year.name !== '') {
                           return false;
                       } else {
                           if (studentsList.study.graduate_year === null && $scope.filterItem.study_end_year.name === '') {
                               return true;
                           } else {
                               if (studentsList.study.graduate_year.toString() === $scope.filterItem.study_end_year.name) {
                                   return true;
                               } else if ($scope.filterItem.study_end_year.name === 'Show All') {
                                   return true;
                               } else {
                                   return false;
                               }
                           }
                       }
                   }
               };
               $scope.customFilterCurator = function (studentsList) {
                   var i;
                   if ($scope.filterItem.curator.surname === 'Show All') {
                       return true;
                   } else {
                       if ($scope.filterItem.curator.surname !== 'Show All') {
                           for (i = 0; i < studentsList.curator.length;) {
                               if (studentsList.curator.length !== 0) {
                                   if (studentsList.curator[i].surname === $scope.filterItem.curator.surname) {
                                       return true;
                                   } else {
                                       i++;
                                   }
                               } else {
                                   return false;
                               }
                           }
                       }
                   }
               };
           });
       })();
    }]);
StudentListCtrl.studentsList =
    function (studentsListFactory, $q) {
        var deferred = $q.defer();
        studentsListFactory.getStudentsList(function (data) {
                deferred.resolve(data);
            }
        );
        return deferred.promise;
    };
StudentListCtrl.student =
    function (studentsListFactory, $q, $route) {
        var deferred = $q.defer();
        studentsListFactory.getStudent({studId: $route.current.params.studId}, function (data) {
                deferred.resolve(data);
            }
        );
        return deferred.promise;
    };
StudentListCtrl.checkElement = function (id, checkedArray) {
    for (var i = 0; i < checkedArray.length; i++) {
        if (checkedArray[i] == id) {
            checkedArray.splice(i, 1);
            return
        }
    }
    checkedArray.push(id);
};
StudentListCtrl.export = function (url, exportData, $http) {
    $http.post(url, exportData)
        .success(function (data) {
            window.location.href = url + '/' + data
        })
        .error(function (data, status) {
            alert('ERROR ' + status);
        });
};

