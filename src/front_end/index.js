'use strict';

<!-- LOGIN AND REGISTER POPUP --------------------------------------------- -->
function openFormIn() {
  document.getElementById("sign_in").style.display = "block";
}

function closeFormIn() {
  document.getElementById("sign_in").style.display = "none";
}

function openFormUp() {
  document.getElementById("sign_up").style.display = "block";
}

function closeFormUp() {
  document.getElementById("sign_up").style.display = "none";
}


<!-- HEATMAP SECTION ------------------------------------------------------ -->
const HttpHeatMap = new XMLHttpRequest();
const urlHeatMap = '/';
HttpHeatMap.open("GET", urlHeatMap);
HttpHeatMap.send();

HttpSign.onreadystatechange = (e) => {
  document.getElementById("heatmap").innerHTML = HttpHeatMap.responseText;
}


<!-- COVID TRACKER -------------------------------------------------------- -->
const HttpTracker = new XMLHttpRequest();
const urlTracker = '/data';
HttpTracker.open("GET", urlTracker);
HttpTracker.send();

HttpSign.onreadystatechange = (e) => {
  document.getElementById("tracker").innerHTML = HttpTracker.responseText;
}


<!-- COMMENT SECTION ------------------------------------------------------ -->
const HttpComments = new XMLHttpRequest();
const urlComments= '/api/reviews';
HttpComments.open("GET", urlComments);
HttpComments.send();

HttpComments.onreadystatechange = (e) => {
  const myArr = JSON.parse(this.responseText);
  myFunction(myArr);
}

function myFunction(arr) {
  var out = "";
  var i;
  for(i = 0; i < arr.length; i++) {
    out += arr[i].id + '<br>' + arr[i].country + '<br>'
    + arr[i].postDate + '<br><br>' + arr[i].textbox;
  }
  document.getElementById("comment_list").innerHTML = out;
}


<!-- END ------------------------------------------------------------------ -->
