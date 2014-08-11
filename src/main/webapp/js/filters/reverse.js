/**
 * Created by Administrator on 11.08.2014.
 */
studentsApp.filter('reverse',function(){
    return function(array) {
        if(array == null)
        return;
        return array.slice().reverse();
    };
});