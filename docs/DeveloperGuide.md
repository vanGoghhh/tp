---
layout: page
title: Developer Guide
---
CANdidates is an open source, brownfield project on the existing [Address book
 Level-3](https://se-education.org/addressbook-level3/). If you are ready to
 contribute to this [project](https://github.com/AY2021S1-CS2103T-T17-3/tp),
 create a pull request [here](https://github.com/AY2021S1-CS2103T-T17-3/tp/pulls).

## CANdidates User Guide

1. [Setting up, getting started](#setting-up-getting-started)
1. [Design](#design)
     1. [Architecture](#architecture)
     1. [User Interface](#ui-component)
     1. [Logic](#logic-component)
     1. [Model](#model-component)
     1. [Storage](#storage-component)
     1. [Common Classes](#common-classes)
1. [Implementation](#implementation)
     1. [Add feature](#implemented-add-feature)
     1. [Edit feature](#implemented-edit-feature)
     1. [List feature](#implemented-list-feature)
     1. [Sort feature](#implemented-sort-feature)
     1. [Find feature](#implemented-find-feature)
1. [Proposed features](#proposed-features)
     1. [Undo/Redo feature](#proposed-undoredo-feature)
         1. [Proposed Implementation](#proposed-implementation)
         1. [Design Consideration](#design-consideration)
             1. [How it executes](#aspect-how-undo--redo-executes)
     1. [Data Archiving](#proposed-data-archiving)
1. [Documentation, Logging, Testing, Configuration, Dev-Ops](#documentation-logging-testing-configuration-dev-ops)
1. [Appendix: Requirements](#appendix-requirements)
     1. [Product Scope](#product-scope)
     1. [User Stories](#user-stories)
     1. [Use Cases](#use-cases)
         1. [Delete a Candidate](#use-case-delete-a-candidate)
         1. [Add a Candidate](#use-case-add-a-candidate)
         1. [Edit a Candidate](#use-case-edit-a-candidate)
         1. [Clear all Candidates](#use-case-clear-all-entries)
     1. [Non-Functional Requirements](#non-functional-requirements)
     1. [Glossary](#glossary)
1. [Appendix: Instructions for Manual Testing](#appendix-instructions-for-manual-testing)
     1. [Launch and Shutdown](#launch-and-shutdown)
     1. [Adding a Candidate](#adding-a-candidate)
     1. [Editing a Candidate](#editing-a-candidate)
     1. [Detecting Duplicate Candidates](#detecting-duplicate-candidates)
     1. [Deleting a Candidate](#deleting-a-candidate)
     1. [Clearing All Candidates](#clearing-all-candidates)
     1. [Saving Data](#saving-data)

--------------------------------------------------------------------------------------------------------------------

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

## **Design**

### Architecture

<img src="images/Architecture.png" width="500" />

The ***Architecture Diagram*** given above explains the high-level design of the App. Given below is a quick overview of each component.

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** The `.puml` files used to create diagrams in this document can be found in the [diagrams](https://github.com/se-edu/addressbook-level3/tree/master/docs/diagrams/) folder. Refer to the [_PlantUML Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/plantUml.html) to learn how to create and edit diagrams.

</div>

**`Main`** has two classes called [`Main`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java). It is responsible for,
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

The rest of the App consists of four components.

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

Each of the four components,

* defines its *API* in an `interface` with the same name as the Component.
* exposes its functionality using a concrete `{Component Name}Manager` class (which implements the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component (see the class diagram given below) defines its API in the `Logic.java` interface and exposes its functionality using the `LogicManager.java` class which implements the `Logic` interface.

![Class Diagram of the Logic Component](images/LogicClassDiagram.png)

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete can 1`.

<img src="images/ArchitectureSequenceDiagram.png" width="600" />

The sections below give more details of each component.

### UI component

![Structure of the UI Component](images/UiClassDiagram.png)

**API** :
[`Ui.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java)

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class.

The `UI` component uses JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* Executes user commands using the `Logic` component.
* Listens for changes to `Model` data so that the UI can be updated with the modified data.

### Logic component

![Structure of the Logic Component](images/LogicClassDiagram.png)

**API** :
[`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java)

1. `Logic` uses the `AddressBookParser` class to parse the user command.
1. This results in a `Command` object which is executed by the `LogicManager`.
1. The command execution can affect the `Model` (e.g. adding a person).
1. The result of the command execution is encapsulated as a `CommandResult` object which is passed back to the `Ui`.
1. In addition, the `CommandResult` object can also instruct the `Ui` to perform certain actions, such as displaying help to the user.

Given below is the Sequence Diagram for interactions within the `Logic` component for the `execute("delete 1")` API call.

![Interactions Inside the Logic Component for the `delete 1` Command](images/DeleteSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
</div>

### Model component

![Structure of the Model Component](images/ModelClassDiagram.png)

**API** : [`Model.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/model/Model.java)

The `Model`,

* stores a `UserPref` object that represents the user’s preferences.
* stores the address book data.
* exposes an unmodifiable `ObservableList<Person>` and an unmodifiable `ObservableList<Job>` that can be 'observed' e.g. the UI can be bound to these lists so that the UI automatically updates when the data in the lists change.
* does not depend on any of the other three components. <br>

<div markdown="span" class="alert alert-info">:information_source: **Note:** The Model class diagram shown above omits certain details due to space constraints, namely the classes in the Information Package 
                                                                             that Person and Job hold reference to. Instead, the omitted details have been extracted and are shown here: <br>

![InformationClassDiagram](images/InformationClassDiagram.png)

</div>
 

### Storage component

![Structure of the Storage Component](images/StorageClassDiagram.png)

**API** : [`Storage.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storage/Storage.java)

The `Storage` component,
* Implements both `PersonAddressBookStorage` and `JobAddressBookStorage`
* can save `UserPref` objects in json format and read it back.
* can save `PersonAddressBook` data and `JobAddressBook` data in json format and read it back.
* `JsonPersonAddressBookStorage` and `JsonJobAddressBookStorage` is reponsible for saving the datas in json format.


### Common classes

Classes used by multiple components are in the `seedu.addressbook.commons` package.

--------------------------------------------------------------------------------------------------------------------

## **Implementation**

This section describes some noteworthy details on how certain features are implemented.

### \[Implemented] Add feature

The Add feature exists, using `add can` for candidates and `add job` for jobs.

Both implemented add mechanisms are facilitated by `ModelManager`. They both implement `Model` and contain `FilteredList` of filtered `Person` and filtered `Job`. `FilteredList` is a subclass of `ObservableList`.

Additionally, it implements the following operations:

* `ModelManager#hasPerson(Person person)` —  Check whether the same person exist in the FilteredList of persons using the `equals` method of `Persons`.

* `ModelManager#addPerson(Person person)` —  Adds the person into the FilteredList of persons.

* `ModelManager#hasJob(Job job)` —  Check whether the same job exist in the FilteredList of jobs using the `equals` method of `Jobs`.

* `ModelManager#addJob(Job job)` —  Adds the job into the FilteredList of jobs.

Given below is an example usage scenario and how the `add can` mechanism behaves at each step. 

Step 1. The user launches the application for the first time. The `FilteredList` will be initialised with the `UniquePersonList` from `personAddressBook` which contains a list of candidates.

Step 2. The user executes `add can n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 exp/5 doa/15-10-20` to add a candidate with `Name` John, `Phone` 98765432, `Email` johnd@example.com, `Address` John street, block 123, #01-01, `Experience` 5 and `Date` 15-10-20.

Step 3. The method `AddressBookParser#parseCommand` is invoked to determine the command type. Since this is an `add can` command, the `AddPersonCommandParser#parse` is then called to parse the arguments. If the input command has an invalid format, `AddPersonCommandParser` throws a `ParseException`, if not, a `AddPersonCommand` object is created.

Step 4. `ModelManager#hasJob(Person person)` is invoked to check whether the same person exist in the FilteredList of persons using the `equals` method of `Persons`. If a duplicate person exists, a `CommandException` is thrown. Otherwise, the method `ModelManager#addPerson(Person person)` is invoked to add the person into the FilteredList of persons.

Step 5. The `savePersonAddressBook` method of `StorageManager`, which is a subclass of `Storage`, is invoked to update the new person addition in the `personAddressBook` and saved. 

The following sequence diagram shows how the `add can` operation works in the scenario described above:

![AddSequenceDiagram](images/AddSequenceDiagram.png)

:information_source: **Note:** The usage scenario and sequence diagram for the analogous `add job` operation are mostly similar, using its `AddJobCommandParser`, `AddJobCommand`, `hasJob`, `addJob`, `saveJobAddressBook` and `JobAddressBook` counterparts.

### \[Implemented] Edit feature

The Edit feature has two variants, one for editing candidates `edit can` and one for editing jobs `edit job` . We will illustrate this feature using only the candidates variant here
as the job variant works analogously. 

The implemented edit mechanism is facilitated by `ModelManager`.  It implements `Model` and contains a `FilteredList`, which is a subclass of `ObservableList`. 
Additionally, it implements the following operations:

*`ModelManager#setPerson(Person target, Person editedPerson)` —  Replaces the Person target  with editedPerson.

*`ModelManager#updateFilteredPersonList(Predicate<Person> predicate)` —  Updates the FilteredList of persons using the supplied predicate.

Given below is an example usage scenario and how the edit mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `FilteredList` will be initialised with the `UniquePersonList` from `personAddressBook` which contains a list of candidates.

Step 2. The user executes `edit can 2 n/Rob Mi` to change the `Name` of the candidate at `Index` 2 to Rob Mi. 

Step 3. The method `AddressBookParser#parseCommand` is invoked to distinguish which type of command it is. After discerning it is an `edit can` command,
the `EditPersonCommandParser#parse` is then invoked to parse the arguments.
If the command format is invalid, `EditPersonCommandParser` throws an error.

Step 4. A `EditPersonDescriptor` object, which is an inner class of `EditPersonCommand`, is created from parsing the command and is used
to store the details to edit the candidate with. In this case, it stores the `Name` Rob Mi.

Step 5. A `EditPersonCommand` object is also created from parsing the comamand. In the `EditPersonCommand#execute` method, 
if the candidate `Index` provided by the user is invalid, an error is thrown. 
Otherwise, the method `ModelManager#setPerson()` is invoked to replace the old candidate with the newly edited candidate. 
 Then, `ModelManager#updateFilteredPersonList()` is invoked and the `FilteredList` and `personAddressBook` is updated and saved.

The following sequence diagram shows how the edit operation works in the scenario described above:

![EditSequenceDiagram](images/EditSequenceDiagram.png)

A `edit job` command works similarly for Jobs but with the analogous EditJobDescriptor, EditJobCommand, JobAddressBook etc. classes.

### \[Implemented] List feature

The implemented list mechanism is facilitated by `ModelManager`. It implements `Model` and contains a `FilteredList`, which is a subclass of `ObservableList`.
Additionally, it implements the following operations:

*`ModelManager#updateFilteredJobList(Predicate<Job> predicate)` —  Updates the FilteredList of jobs using the supplied predicate.

Given below is an example usage scenario and how the list mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `FilteredList` will be initialised with the `UniqueJobList` from `jobAddressBook` which contains a list of jobs.

Step 2. The user executes `list job` to list all jobs.

Step 3. A `ListJobCommand` object is created from parsing the command. In the `ListJobCommand#execute` the method `ModelManager#updateFilteredJobList(PREDICATE_SHOW_ALL_JOBS)` is invoked 
and the `FilteredList` shows all jobs in the list as indicated by the given predicate.

The following sequence diagram shows how the find operation works in the scenario described above:

![ListSequenceDiagram](images/ListSequenceDiagram.png)

### \[Implemented] Sort feature

The implemented sort mechanism is facilitated by `ModelManager`. It implements `Model` and contains a `SortedList`, which is a subclass of `ObservableList`.
Additionally, it implements the following operations:

* `ModelManager#updateSortedPersonList(Comparator<Person> comp)` —  Sorts the current SortedList of persons using the supplied comparator.

Given below is an example usage scenario and how the sort mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `SortedList` will be initialised with the `UniquePersonList` from `personAddressBook` which contains a list of candidates.

Step 2. The user executes `sort can type/exp order/asc` to sort the candidates by their `Experience` in ascending order. If the `type` of comparator field e.g. `exp` or the `order` e.g `asc` is missing, `SortPersonCommandParser` throws an error message.

Step 3. A `PersonExperienceComparator` is created from parsing the command and a `SortPersonCommand` object is created. In the `SortPersonCommand#execute` the method `ModelManager#updateSortedPersonList(PersonExperienceComparator)` is invoked and the `SortedList` is sorted using the `PersonExperienceComparator`. The `UniquePersonList` in `personAddressBook` is then set to be the `SortedList`.

![SortPersonSequenceDiagram](images/SortSequenceDiagramC.png)

### \[Implemented] Find feature

The implemented find mechanism is facilitated by `ModelManager`. It implements `Model` and contains a `FilteredList`, which is a subclass of `ObservableList`.
Additionally, it implements the following operations:

*`ModelManager#updateFilteredPersonList(Predicate<Person> predicate)` —  Updates the FilteredList of persons using the supplied predicate.

Given below is an example usage scenario and how the find mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `FilteredList` will be initialised with the `UniquePersonList` from `personAddressBook` which contains a list of candidates.

Step 2. The user executes `find can n/John` to find candidates with the `Name` John.

Step 3. A `PersonNameContainsKeywordsPredicate`, which is a subclass of `Predicate` is created from parsing the command and a `FindCommand` object is created. In the `FindCommand#execute` the method `ModelManager#updateFilteredPersonList(PersonNameContainsKeywordsPredicate)` is invoked and the `FilteredList` is filtered using the `PersonNameContainsKeywordsPredicate`.

The following sequence diagram shows how the find operation works in the scenario described above:

![FindSequenceDiagram](images/FindSequenceDiagram.png)

The find operation is subjected to improvements to be implemented in v1.3 where we will allow users to find candidates or jobs using other fields like address, tags, vacancy, etc.

## Proposed Features

### \[Proposed\] Undo/redo feature

#### Proposed Implementation

The proposed undo/redo mechanism is facilitated by `VersionedPersonAddressBook`. It extends `PersonAddressBook` and `VersionedJobAddressBook` respectively with an undo/redo history, stored internally as an `personAddressBookStateList` and `currentStatePointer`. Additionally, it implements the following operations:

* `VersionedPersonAddressBook#commit()` — Saves the current person address book state in its history.
* `VersionedPersonAddressBook#undo()` — Restores the previous person address book state from its history.
* `VersionedPersonAddressBook#redo()` — Restores a previously undone person address book state from its history.

These operations are exposed in the `Model` interface as `Model#commitPersonAddressBook()`, `Model#undoPersonAddressBook()` and `Model#redoPersonAddressBook()` respectively.

Given below is an example usage scenario and how the undo/redo mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `VersionedPersonAddressBook` will be initialized with the initial person address book state, and the `currentStatePointer` pointing to that single person address book state.

![UndoRedoState0](images/UndoRedoState0.png)

Step 2. The user executes `delete can 5` command to delete the 5th person in the address book. The `delete can` command calls `Model#commitPersonAddressBook()`, causing the modified state of the person address book after the `delete can 5` command executes to be saved in the `personAddressBookStateList`, and the `currentStatePointer` is shifted to the newly inserted person address book state.

![UndoRedoState1](images/UndoRedoState1.png)

Step 3. The user executes `add can n/David …​` to add a new person. The `add can` command also calls `Model#commitPersonAddressBook()`, causing another modified address book state to be saved into the `addressPersonBookStateList`.

![UndoRedoState2](images/UndoRedoState2.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If a command fails its execution, it will not call `Model#commitPersonAddressBook()`, so the address book state will not be saved into the `personAddressBookStateList`.

</div>

Step 4. The user now decides that adding the person was a mistake, and decides to undo that action by executing the `undo can` command. The `undo can` command will call `Model#undoPersonAddressBook()`, which will shift the `currentStatePointer` once to the left, pointing it to the previous person address book state, and restores the address book to that state.

![UndoRedoState3](images/UndoRedoState3.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index 0, pointing to the initial PersonAddressBook state, then there are no previous PersonAddressBook states to restore. The `undo can` command uses `Model#canUndoPersonAddressBook()` to check if this is the case. If so, it will return an error to the user rather
than attempting to perform the undo.

</div>

The following sequence diagram shows how the undo operation works:

![UndoSequenceDiagram](images/UndoSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `UndoPersonCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

</div>

The `redo can` command does the opposite — it calls `Model#redoPersonAddressBook()`, which shifts the `currentStatePointer` once to the right, pointing to the previously undone state, and restores the person address book to that state.

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index `personAddressBookStateList.size() - 1`, pointing to the latest person address book state, then there are no undone PersonAddressBook states to restore. The `redo can` command uses `Model#canRedoPersonAddressBook()` to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</div>

Step 5. The user then decides to execute the command `list can`. Commands that do not modify the address book, such as `list can` and `help`, will usually not call `Model#commitPersonAddressBook()`, `Model#undoPersonAddressBook()` or `Model#redoPersonAddressBook()`. Thus, the `personAddressBookStateList` remains unchanged.

![UndoRedoState4](images/UndoRedoState4.png)

Step 6. The user executes `clear can`, which calls `Model#commitPersonAddressBook()`. Since the `currentStatePointer` is not pointing at the end of the `personAddressBookStateList`, all address book states after the `currentStatePointer` will be purged. Reason: It no longer makes sense to redo the `add can n/David …​` command. This is the behavior that most modern desktop applications follow.

![UndoRedoState5](images/UndoRedoState5.png)

The following activity diagram summarizes what happens when a user executes a new command:

![CommitActivityDiagram](images/CommitActivityDiagram.png)

<div markdown="span" class="alert alert-info">

:information_source: **Note:** The analogous `redo job` and `undo job` features can be implemented in the same way, using its `VersionedJobAddressBook`, `JobAddressBook` and `jobAddressBookStateList` counterparts.

</div>

#### Design consideration:

##### Aspect: How undo & redo executes

* **Alternative 1 (current choice):** Saves the entire address book.
  * Pros: Easy to implement.
  * Cons: May have performance issues in terms of memory usage.

* **Alternative 2:** Individual command knows how to undo/redo by
  itself.
  * Pros: Will use less memory (e.g. for `delete`, just save the person being deleted).
  * Cons: We must ensure that the implementation of each individual command are correct.

--------------------------------------------------------------------------------------------------------------------

## **Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Requirements**

### Product scope

**Target user profile**: Job Recruiter

* Has a need to manage a significant number of contacts, specifically job openings and job candidates
* Has a need to store relevant additional information of job openings and job candidates other than contact details
* Prefer desktop apps over other types
* Can type fast
* Prefers typing to mouse interactions
* Is reasonably comfortable using CLI apps

**Value proposition**: 

* Manage contacts faster than a typical mouse/GUI driven app. 
* Convenient access to contact details of job candidates as well as job openings on one centralised platform.
* Store additional information for job openings such as priority and number of vacancies.
* Store additional information for job candidates such as years of experience and expected salary.
* Search for job candidates and job openings by various fields.
* Sort job candidates and job openings by various fields.


### User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …​                                 | I want to …​                                                                       | So that I can…​                                                                         |
| -------- | ------------------------------------------ | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------ |
| `* * *`  | job recruiter                              | have a platform to consolidate all _information_ of candidates                        |  avoid receiving applications from the same people repeatedly                              |
| `* * *`  | job recruiter                              | have a way to filter candidates by the type of job they are applying for              |                                                                                            |
| `* * *`  | job recruiter                              | have a way to be able to delete candidates when they are successfully hired           | optimise my search                                                                         |
| `* * *`  | job recruiter                              | have a way to keep track of duplicate candidates                                      | avoid adding the same candidate multiple times                                             |
| `* * *`  | job recruiter                              | keep the links to candidates' resumes (GitHub, LinkedIn, etc.)                        | review them conveniently                                                                   |
| `* * *`  | job recruiter                              | be able to delete job listings when they are filled up                                |                                                                                            |
| `* * *`  | job recruiter                              | be able to filter jobs by their vacancies                                             |                                                                                            |
| `* * *`  | job recruiter                              | be able to tag jobs with different priorities                                         |                                                                                            |
| `* * *`  | job recruiter                              | be able to filter jobs by their priorities                                            |                                                                                            |
| `* * *`  | careless job recruiter                     | have a way to edit the contacts                                                       | rectify wrong entries                                                                      |
| `* *`    | new user exploring the application         | see sample data stored in the App                                                     | see how the App would work when it is in use                                               |
| `* *`    | technology inept person                    | have an App that is intuitive to use                                                  |                                                                                            |
| `* *`    | aesthetic individual                       | have an App that is clean and aesthetically pleasing                                  |                                                                                            |
| `* *`    | job recruiter                              | have a way to filter candidates by the date they applied for the job                  |                                                                                            |
| `* *`    | job recruiter                              | have a way to filter candidates by their years of experience                          |                                                                                            |
| `* *`    | job recruiter                              | have a way to blacklist candidates that do not respond or have poor attitudes         | take note to not consider them again in the future                                         |
| `* *`    | job recruiter                              | have a way to organise my contact information easily                                  |                                                                                            |
| `* *`    | job recruiter                              | have a way to sort candidates based on their expected salary                          |                                                                                            |
| `* *`    | job recruiter                              | be brought directly to the relevant pages to view the candidates’ further information |                                                                                            |
| `* *`    | job recruiter                              | be able to view the ranking of the candidates based on various _criteria_             | provide a list of candidates that best fulfil the recruitment criteria(s) to the companies |
| `* *`    | job recruiter                              | be notified of duplicate job listings when adding a new entry to the list             |                                                                                            |
| `* *`    | efficient job recruiter                    | be able to effectively search for candidates whenever there is a new job opening      | answer to hiring companies quickly                                                         |
| `* *`    | veteran job recruiter                      | be able to store as many contacts as possible without lagging the software            |                                                                                            |
| `* *`    | user that is ready to start using the app  | have an easy way to clear all the sample data                                         | fill in my data                                                                            |
| `*`      | job recruiter                              | have a way to keep track of interview schedules                                       |                                                                                            |
| `*`      | single person                              | have a way to store the contacts of cute job applicants                               |                                                                                            |
| `*`      | long term user of the App                  | have a way to archive some of the unused data                                         | prevent cluttering                                                                         |
| `*`      | efficient person                           | be able to perform mass operations like deleting multiple entries at once             |                                                                                            |
| `*`      | job recruiter                              | have a way to filter job applicants by their gender                                   |                                                                                            |

### Use cases

(For all use cases below, the **System** is the `CANdidates` and the **Actor** is the `user`, unless specified otherwise)
      

#### **Use case: UC01 - Add a candidate**

**MSS**

1.  User adds a candidate
2.  CANdidates shows a list of candidates, containing the newly added candidate

    Use case ends.

**Extensions**

* 1a. Input format is invalid.

    * 1a1. CANdidates shows an error message.

      Use case ends.

* 1b. The given candidate already exists.

    * 1b1. CANdidates shows an error message.

      Use case ends.


#### **Use case: UC02 - List candidates**

**MSS**

1.  User requests to list candidates
2.  CANdidates shows a list of candidates

    Use case ends.

**Extensions**

* 1a. Input format is invalid.

    * 1a1. CANdidates shows an error message.

      Use case ends.


#### **Use case: UC03 - Delete a candidate**

**MSS**

1.  User requests to _list candidates (UC01)_
2.  User requests to delete a specific candidate index in the list
3.  CANdidates deletes the candidate

    Use case ends.

**Extensions**

* 1a. The list is empty.

  Use case ends.

* 2a. The given index is invalid.

    * 2a1. CANdidates shows an error message.

      Use case ends.


#### **Use case: UC04 - Edit a candidate**

**MSS**

1.  User requests to _list candidates (UC01)_
2.  User requests to edit the details of a specific candidate index in the list
3.  CANdidates edits the candidate

    Use case ends.

**Extensions**

* 1a. The list is empty.

  Use case ends.
  
* 2a. The given index is invalid.

    * 2a1. CANdidates shows an error message.

      Use case ends.

* 2b. The format of the given details are invalid.

    * 2b1. CANdidates shows an error message.

      Use case ends.


#### **Use case: UC05 - Clear all candidates**

**MSS**

1.  User requests to _list candidates (UC01)_
2.  User requests to clear all candidates in the list
3.  CANdidates clears the list

    Use case ends.

**Extensions**

* 1a. The list is empty.

  Use case ends.


#### **Use case: UC06 - Find candidates**

**MSS**

1.  User requests to find candidates with keywords
2.  CANdidates shows a list of candidates matching keywords

    Use case ends.

**Extensions**

* 1a. Input format is invalid.

    * 1a1. CANdidates shows an error message.

      Use case ends.


#### **Use case: UC07 - Sort candidates**

**MSS**

1.  User requests to _list candidates (UC01)_
2.  User requests to sort the list in an order based on a field type
3.  CANdidates displays the list of candidates in the specified order

    Use case ends.

**Extensions**

* 1a. The list is empty.

  Use case ends.
  
* 2a. The given field type is invalid.

    * 2a1. CANdidates shows an error message.

      Use case ends.

* 2b. The given order is invalid.

    * 2b1. CANdidates shows an error message.

      Use case ends.


#### **Use case: UC08 - Add a job**

Similar to UC01, except user will request to add a job instead.


#### **Use case: UC09 - List jobs**

Similar to UC02, except user will request to list jobs and CANdidates will show a list of jobs instead.


#### **Use case: UC10 - Delete a job**

Similar to UC03, except user will request to delete a specific job index.


#### **Use case: UC11 - Edit a candidate**

Similar to UC04, except user will request to edit details of a specific job index.


#### **Use case: UC12 - Clear all jobs**

Similar to UC05, except user will request to clear all jobs.


#### **Use case: UC13 - Find candidates**

Similar to UC06, except user will request to find jobs with keywords and CANdidates will show a list of jobs instead.


#### **Use case: UC14 - Sort candidates**

Similar to UC07, except user will request to sort jobs.


#### **Use case: UC15 - Requesting for help**

**MSS**

1.  User requests for help
2.  CANdidates displays help window with link to User Guide
3.  User copies the link and closes the window

    Use case ends.


### Non-Functional Requirements

1.  Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
1.  Should be able to hold up to 1000 persons without a noticeable sluggishness in performance for typical usage.
1.  A user with above average typing speed for regular English text (i.e. not code, not system admin commands)
 should be able to accomplish most of the tasks faster using commands than using the mouse.
1.  Should be a single user product.
1.  The data should be stored locally in a human editable text file.
1.  Should work without requiring an installer.
1.  Should not include _hard-to-test features_.
1.  The project is expected to adhere to a schedule that delivers a feature set every one to two weeks.
1.  Should have an intuitive interface for new users to pick up the application easily.
1.  Should be able to work without an internet connection.
1.  Any reused code should be used with appropriate credit given.
1.  Should not include copyrighted audio or graphics.

### Glossary

* **Information**: Name, phone number, address, job type etc.
* **Criteria**: Work experience, language and other skills.
* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **Hard-to-test features**: Features that heavily depend on remote APIs, audio-related features,
as well as features requiring creation of user accounts etc.
--------------------------------------------------------------------------------------------------------------------

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</div>

### Launch and shutdown

1. Initial launch

   1. Download the jar file and copy into an empty folder

   1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

1. Saving window preferences

   1. Resize the window to an optimum size. Move the window to a different location. Close the window.

   1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

1. _{ more test cases …​ }_

### Adding a candidate

1. Adding a candidate while on the candidates tab and all candidates are displayed 

    1. Prerequisites: List all candidates on the candidates tab using the `list can` command.
    
    1. Test case (specifying only compulsory input fields): `add can n/Rob p/88888888 e/e@mail.com doa/01-02-20 exp/5.5`
       Expected: A new candidate is added at the end of the candidates list. 
       Details of the added candidate shown in the status message. The compulsory input fields are set to the values specified in the command. 
       The optional `Address`, `Salary`, `Link` and `Tag` fields are empty. The optional `Blacklisted` field is set to false by default.
       
    1. Test case (missing a compulsory input field): `add can n/Rob p/88888888 e/e@mail.com doa/01-02-20`
       Expected: No new candidate is added. Invalid command format error shown in the status message due to the command
       missing the compulsory `exp/YEARS_OF_EXPERIENCE` input field.
       
    1. Other incorrect add commands to try include omitting other compulsory fields. <br>
       Expected: Similar to previous  
   
   <div markdown="span" class="alert alert-info">:information_source: **Note:** Adding jobs can be tested in the same way but with its analogous commands and input fields.
   
   </div>
     
### Editing a candidate

1. Editing a candidate while on the candidates tab and all candidates are displayed 

    1. Prerequisites: Perform test case 1.2 from [Adding a candidate](#adding-a-candidate) to add a new candidate and verify that it is passes.
    
    1. Test case: `edit can INDEX n/Ron bl/true` where `INDEX` is the list index of the candidate just added in the prerequisite step <br>
       Expected: The `Name` of the candidate at index `INDEX` changes from _Rob_ to _Ron_ and `Blacklisted` changes from _false_ to _true_.
       No other input fields are changed (rest of the fields remain same). Details of the edited candidate shown in the status message.
       
    1. Test case: `edit can INDEX` where `INDEX` is the list index of the candidate just added in the prerequisite step <br>
       Expected: No candidate is edited. No fields provided error shown in the status message.
       
    
### Detecting duplicate candidates

1. Detecting and preventing the creation of duplicate candidates
     
   1. Prerequisites: Perform test case 1.2 from [Adding a candidate](#adding-a-candidate) to add a new candidate and verify that it is passes. 
   
   1. Test case (Same name and phone): `add can n/Rob p/88888888 e/mail@gmail.com doa/08-10-22 exp/15` <br>
      Expected: No new candidate is added. Duplicate candidate error shown in the status message.
      
   1. Test case (Same name and email): `add can n/Rob p/12345 e/e@mail.com doa/08-10-22 exp/15` <br>
      Expected: No new candidate is added. Duplicate candidate error shown in the status message.    

### Deleting a candidate

1. Deleting a candidate while on the candidates tab and all candidates are displayed

   1. Prerequisites: List all candidates on the candidates tab using the `list can` command. Multiple candidates in the candidates list.

   1. Test case: `delete can 1`<br>
      Expected: First candidate contact is deleted from the candidates list. Details of the deleted candidate shown in the status message.

   1. Test case: `delete can 0`<br>
      Expected: No candidate is deleted. Invalid candidate index error shown in the status message.

   1. Other incorrect delete commands to try: `delete can`, `delete can -1`, `delete can x` (where x is larger than the list size)<br>
      Expected: Similar to previous.

2. Deleting a candidate while on the job listings tab
    
    1. Prerequisites: Switch to the job listings tab using the `list job` command. Multiple candidates in the candidates list.
    
    1. Test case:  `delete can 1`<br>
       Expected:  The tab switches from the job listings tab to the candidates tab automatically. First condidate contact is deleted 
       from the candidates list. Details of the deleted candidate shown in the status message.
     
    1. Test case:  `delete can 0`<br>
       Expected: The tab does not switch to the candidates tab. No candidate is deleted. Invalid candidate index error shown in the status message. 
       
    1. Other incorrect delete commands to try: `delete can`, `delete can -1`, `delete can x` (where x is larger than the list size)<br>
       Expected: Similar to previous.  
       
<div markdown="span" class="alert alert-info">:information_source: **Note:** Deleting jobs can be tested in the same way but with its analogous commands.

</div>
       
### Clearing all candidates

1. Clearing all candidates while on the candidates tab and all candidates are displayed

    1. Prerequisites: List all candidates on the candidates tab using the `list can` command. Multiple candidates in the candidates list.
    
    1. Test case: `clear can`<br>
       Expected: All candidate contacts are deleted from the candidate list. Clear candidate success message shown in the status message. 
       
    1. Test case: `clear`<br>
       Expected: No candidates or jobs are deleted. Unknown command error shown in the status message.
       
2. Clearing all candidates while on the job listings tab

    1. Prerequisites: Switch to the job listings tab using the `list job` command. Multiple candidates in the candidates list.
    
    1. Test case:  `clear can`<br>
       Expected:  The tab switches from the job listings tab to the candidates tab automatically. 
       All candidate contacts are deleted from the candidate list. Clear candidate success message shown in the status message.
              
    1. Test case: `clear`<br>
       Expected: No candidates or jobs are deleted. Unknown command error shown in the status message.    
       
<div markdown="span" class="alert alert-info">:information_source: **Note:** Clearing all jobs can be tested in the same way but with its analogous commands.

</div>


### Saving data

1. Dealing with missing/corrupted data files

   1. _{explain how to simulate a missing/corrupted file, and the expected behavior}_

1. _{ more test cases …​ }_
