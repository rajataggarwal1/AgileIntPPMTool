import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import Header from "./Layout/Header";

class Dashboard extends Component {
  render() {
    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Projects</h1>
              <br />
              <a href="ProjectForm.html" className="btn btn-lg btn-info">
                Create a Project
              </a>
              <br />
              <hr />
              {
                // Importing project item to show the project items
              }
              <ProjectItem />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Dashboard;
