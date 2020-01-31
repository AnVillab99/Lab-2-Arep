# AREP Lab2

This laboratory intends for the students to implement the previous laboratory, the calculator, on a simple web page employing spark.

As in the previous one, we need to return the mean and the standard deviation of some given numbers. Nonetheless, this time the data must be collected from a web page, and must be shown on a web page, for this, we need to implement a communication between the page and the server with http petitions.

## Getting Started

You can download a copy of the project from github, to run it you need to run SparkWebApp.java from console, or heroku local web

### Prerequisites

You will need maven, java and heroku cli installed on the computer to run this program.


### Installing

First you need to install java and jdk.
Go to java page and download both, install them and add the paths of those folders to the enviroment variables of your pc.
For maven you download the zip archive from the maven page and unpack it on a specific folder, the you add the path to that folder on the enviroment variables
For Heroku, you need to go to heroku main page and follow thye download and installation instructions, after that you need to setup the heroku credentials.
To deploy on local, the Procfile must be changed to:
>web: java -cp target\classes;target\dependency\* edu.escuelaing.arep.designprimer.SparkWebApp


## Running the program

Heroku link: https://boiling-crag-06097.herokuapp.com

The main page  :
![test](https://github.com/AnVillab99/Lab-2-Arep/blob/master/resources/img/WebCalculator.png)

The results :
![expected](https://github.com/AnVillab99/Lab-2-Arep/blob/master/resources/img/WebCalculatorLocal.png)

## Design

On the emebeded pdf document is a simple description of the design of this project 


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [JAVA](https://www.java.com/es/download) - Framework
* [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Framework
* [Heroku](https://devcenter.heroku.com/articles/heroku-cli) - Deployment

## Versioning

For the versions available, see the [tags on this repository](https://github.com/AnVillab99/AREP-Lab1/tags). 

## Authors

* **Andres Villamil**  [AnVillab99](https://github.com/AnVillab99)


## License

This project is under GNU General Public License - see [LICENSE](https://github.com/AnVillab99/AREP-Lab1/blob/master/LICENSE) to more info.

## Acknowledgments

* StackOverflow

