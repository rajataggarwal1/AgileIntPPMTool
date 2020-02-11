import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import Header from "./Layout/Header";

class Dashboard extends Component {
  render() {
    return (
      <div>
        <Header />
        <h1>Welcome to dasdboard</h1>
        <ProjectItem />
      </div>
    );
  }
}

export default Dashboard;