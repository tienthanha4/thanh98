function showPage() {
 
  document.getElementById("loader").style.display = "none";  
  document.getElementById("all-1").style.display = "block";
  document.getElementById("all-2").style.display = "block";
  document.getElementById("all-3").style.display = "block";
  document.getElementById("all-4").style.display = "block";
}
function myFunction() {

    document.getElementById("all-1").style.display = "none";
    document.getElementById("all-2").style.display = "none";
    document.getElementById("all-3").style.display = "none";
    document.getElementById("all-4").style.display = "none";
    document.getElementById("loader").style.display = "block"; 
    myVar = setTimeout(showPage, 3000);


}






