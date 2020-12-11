'use strict';



<!-- HEATMAP SECTION ------------------------------------------------------ -->
const a = React.createElement;

class HeatMap extends React.Component {
  constructor() {
    super();
  }
  render() {
    return a(
      'button',
      { onClick: () => this.setState({ liked: true }) },
      'Heatmap PlaceHolder'
    );
  }
}

const HeatMapContainer = document.querySelector('#heatmap');
ReactDOM.render(a(HeatMap), HeatMapContainer);



<!-- COMMENT SECTION ------------------------------------------------------ -->


<!-- SIGN UP -->




<!-- COMMENT LIST ---- -->
const HttpComments = new XMLHttpRequest();
const urlComments= '';
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
    out += arr[i].username + '<br>' + arr[i].comment + '<br>'
    + arr[i].date;
  }
  document.getElementById("#comment_list").innerHTML = out;
}



<!-- LIKE BUTTON -->
const l = React.createElement;

class LikeButton extends React.Component {
  constructor(props) {
    super(props);
    this.state = { liked: false };
  }

  render() {
    if (this.state.liked) {
      return 'You liked this.';
    }

    return l(
      'button',
      { onClick: () => this.setState({ liked: true }) },
      'Like'
    );
  }
}
const likeContainer = document.querySelector('#like_button');
ReactDOM.render(l(LikeButton), likeContainer);



<!-- REPORT BUTTON -->
const r = React.createElement;

class ReportButton extends React.Component {
  constructor(props) {
    super(props);
    this.state = { liked: false };
  }

  render() {
    if (this.state.liked) {
      return 'Comment Reported.';
    }

    return r(
      'button',
      { onClick: () => this.setState({ liked: true }) },
      'Report'
    );
  }
}
const ReportContainer = document.querySelector('#report_button');
ReactDOM.render(r(ReportButton), ReportContainer);



<!-- END ----------------------------------------------------------------0- -->
