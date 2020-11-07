---
layout: page
title: Lee Joon Jie's Project Portfolio Page
---

## Project: CANdidates

CANdidates is a powerful contact management desktop App optimised for job recruiters to manage job applicants and job listings.
The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 20 kLoC.

<img src="/docs/images/breadpeanutbutter.png" width="200px">

[[github](http://github.com/BreadPeanutButter)]

* Role: Developer
* Responsibilities: Code Quality and Standards

### Given below are my contributions to the project

Given below are my contributions to the project.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=breadpeanutbutter&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=false)

* **New Feature: Experience Information field**
  * What it is for: A field used to represent the number of years of experience of a candidate. Internally, it is represented as an Experience object.
  * Justification: This Information field allows job recruiters to store and keep track of the number of years of experience that candidates have.
    This is an important value that most employers look out for. This field is also useful when used as input for the Sort and Find features. 
      
* **New Feature: URL Link Information field**     
  * What it is for: A field used to represent a URL link to a candidate's profile such as his/her LinkedIn or Github page. 
    It is an optional input field for candidates. Internally, it is represented as a UrlLink object.
  * Justification: This Information field allows job recruiters to have easy access to the URL link to profiles and resumes of candidates. 
  * Highlight: This field was the first information field to be optional as an input to candidate and also have no default value. It was a challenge to
    implement this field as I had to consider how to make it truly optional while adhering to good coding practices. I wanted to avoid using
    null values for this as they can be prone to errors. Hence, I decided to utlise Java's Optional class to contain UrlLink in an Optional object. 
  * Hightlight: It was also a challenge to validate the format of URL links as there are numerous possibilities. I decided to use a third party library, 
    Apache Commons Validator, to validate the format for this.
    
* **New Feature: Salary Information field**           
  * What it is for: A field used to represent the expected salary of a candidate. It is an optional input field for candidates. 
    Internally, it is represented as a Salary object.
  * Justification:  This Information field allows job recruiters to store and keep track of the expected salary of candidates. This is an important field
  as recruiters can use this information to match candidates with suitable jobs. This field is also useful when used as input for the Sort and Find features.
  * Highlight: Similar to URLLink, Salary is also represented as an Optional object in candidates.
  
* **New Feature: Date Information field**           
  * What it is for: A field used to represent the date of application of a candidate. Internally, it is represented as a Date object.
  * Justification: This Information field allows job recruiters to keep track of the date that candidates applied for a job. This is important as 
    job recruiters should not take too long to follow up with candidates or they might lose the candidate. 
    This field is also useful when used as input for the Sort and Find features.
    
* **New Feature: Blacklist Information field**           
  * What it is for: A field used to represent the blacklist status of candidates, i.e whether a candidate has been blacklisted.
  * Justification: This Information field allows job recruiters to keep track of candidates who have been blacklisted and have bad records. 
    Recruiters will then know not to hire this person in the future. This field is also useful when used as input for the Sort and Find features.

* **Project management**: 
  * In charge of looking after code quality and ensuring adherence to coding standards such as SLAP and KISS principles.

* **Enhancements to existing features**: 
  * Implemented editing of candidates and jobs: `add can` and `add job`
  * Implemented deleting of candidates and jobs: `delete can` and `delete job`
  * Implemented clearing of candidates and jobs: `clear can` and `clear job`
  * Added command summary table to Help Window
  * Modified AddressBookParser class of AB3 to be able to parse new commands of CANdidates
  * Modified existing Information fields to adhere to new requirements, such as being optional and having a maximum length of input
  * Created several new test classes used to test Information fields
  * Updated old tests to include new features

* **Documentation**:
  * User Guide:
    * Wrote documentation for Editing a candidate: `edit can` and Editing a job: `edit job`
    * Wrote documentation for Deleting a candidate: `delete can` and Deleting a job: `delete job`
    * Wrote documentation for Clearing all candidate entries: `clear can` and Clearing all job entries: `clear job`
    * Wrote documentation for Detecting duplicate entries
    * Wrote some parts of the Introduction, FAQ, Command Summary and Glossary
  * Developer Guide:
    * Updated the Design of the Model component including the UML diagram along with team mate [Amelia Tan](ameliatjy.md)
    * Wrote documentation for implementation of Edit feature including sequence diagram
    * Updated Product Scope with Target user profile and Value proposition
    * Updated Instructions for Manual Testing with tests for Adding a candidate, 
      Editing a candidate, Detecting duplicate candidates, Deleting a candidate and Clearing all entries.

* **Community**: 
  * PRs reviewed (with non-trivial review comments): [\#]()

* **Tools**: 
  * Integrated a third party library (Apache Commons Validator) to the project used to 
    check the validity of the format of URL links in the UrlLink class([\#]())


