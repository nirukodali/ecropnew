function get_name(url)
{
var ss=url;
var xmlHttp;
var distcrs="";
var url="";
var res;
db.transaction(function (tx) {
var sqlsearch="SELECT name from empmaster WHERE role='user'";
alert(name);
console.log(sqlsearch);
tx.executeSql(sqlsearch, [], function (tx, results) {
var len = results.rows.length;
// // alert(len);
if(len>=1){
res="";
for(i=0;i<len;i++){

res+=results.rows.item(i).name+"!"+results.rows.item(i).name+"@";

}
 // alert(ss);
aa(ss);
}
});

});

function aa(url){
document.getElementById(url).options.length=0;
arr1=res.split("@");
var x=document.getElementById(url);
y=document.createElement('option');
y.value="Select";
y.text="Select";
try{
x.add(y,null); // standards compliant
}catch(ex){
x.add(y); // Internet Explorer only
}
for(i=0;i< arr1.length-1;i++){
var arr2 = arr1[i].split("!");
y=document.createElement('option');
y.value=arr2[0]
y.text=arr2[1];
x=document.getElementById(url);
try{
x.add(y,null); // standards compliant
}catch(ex){
x.add(y); // Internet Explorer only
}
}//for
}
}