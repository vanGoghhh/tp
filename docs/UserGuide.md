---
layout: page
title: User Guide
---

CANdidates is a powerful and optimized contact management
app for job recruiters to manage job applicants and job listings.

## CANdidates User Guide

1. [Introduction](#introduction)
     1. [Author](#authors)
1. [Preface](#preface)
     1. [Understanding Symbols](#understanding-symbols)
     1. [Understanding Input Fields](#understanding-input-fields)
2. [Quick start](#quick-start)
1. [Features](#features)
     1. [Viewing help: help](#viewing-help-help)
     1. [Adding a candidate: add can](#adding-a-candidate-add-can)
     1. [Adding a job listing: add job](#adding-a-job-listing-add-job)
     1. [Listing all candidates: list can](#listing-all-candidates-list-can)
     1. [Listing all jobs: list job](#listing-all-jobs-list-job)
     1. [Editing a candidate: edit can](#editing-a-candidate-edit-can)
     1. [Editing a job: edit job](#editing-a-job-edit-job)
     1. [Finding a candidate: find can](#finding-a-candidate-find-can)
     1. [Finding a job: find job](#finding-a-job-find-job)
     1. [Sorting all candidates: sort can](#sorting-all-candidates-find-can)
     1. [Sorting all jobs: sort job](#sorting-all-jobs-sort-job)
     1. [Deleting a candidate: delete can](#deleting-a-candidate-delete-can)
     1. [Deleting a job: delete job](#deleting-a-job-delete-job)
     1. [Clearing all candidate entries: clear can](#clearing-all-candidate-entries--clear-can)
     1. [Clearing all job entries: clear job](#clearing-all-job-entries-clear-job)
     1. [Exiting the program : exit](#exiting-the-program-exit)
     1. [Saving the data](#saving-the-data)
1. [FAQ](#faq)
1. [Command summary](#command-summary)
1. [Glossary](#glossary)

--------------------------------------------------------------------------------------------------------------------

## Introduction

### Authors

--------------------------------------------------------------------------------------------------------------------

## Preface

### Understanding Symbols

ame | mez
--------|------------------------------------
`Command` | abc
:sushi: | abc
:memo: | abc
:bulb: | abc
:exclamation: | abc

### Understanding Input Fields

germ | sie
--------|------------------------------------
`Field` | `add can n/NAME p/PHONE_NUMBER e/EMAIL`
`Field` | `clear can`
`Field` | `delete can INDEX`
`Field` | `edit can INDEX [n/NA`
`Field` | `list can`
`Field` | `help`
`Field` | `exit`

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Download the latest `candidates.jar` from [here](https://github.com/AY2021S1-CS2103T-T17-3/tp/blob/master/docs).

1. Copy the file to the folder you want to use as the _home folder_ for your CANdidates.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list can`** : Lists all candidates.

   * **`add can`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 exp/5 doa/15-10-20` : Adds a candidate named 'John Doe' with phone number '98765432', email 'johnd@example.com', address 'John street, block 123, #01-01', years of experience '5' and date of application '15-10-20' to the candidate list.

   * **`delete can`**`3` : Deletes the 3rd candidate shown in the current candidate list.

   * **`clear can`** : Deletes all candidates.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

<div markdown="span" class="alert alert-primary">
:exclamation: Ensure you have Java 11 or above installed in your Computer.

:bulb: If you are confused with the various input fields, refer to [Understanding Input Fields](#understanding-input-fields).
</div>
<br>

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:memo: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/JOB_TYPE]` can be used as `n/John Doe t/programmer` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/JOB_TYPE]…​` can be used as ` ` (i.e. 0 times), `t/accountant`, `t/programmer t/technician` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

*:bulb: If you are confused with the various input fields, refer to [Understanding Input Fields](#understanding-input-fields).*
</div>

### Viewing help: `help`

If you are unsure of how to use the application, we have a help function that will direct you to our user guide! The user guide can also be found [here](https://tinyurl.com/candidatesUG).

![help message](images/helpMessage.png)

Format: `help`

### Adding a candidate: `add can`

If you have a new candidate who approached you and you would like to put him in CANdidates, you can add him into the list using the command below.

Format: `add can n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS exp/YEARS_OF_EXPERIENCE doa/DATE_OF_APPLICATION [t/JOB_TYPE]…​ [sal/EXPECTED_SALARY] [bl/IS_BLACKLISTED] [link/PROFILE_LINK]`

<div markdown="span" class="alert alert-primary">

:bulb: *A candidate can have 0 or more job type(s)*.

:memo: *The blacklist input can be specified as* `bl/true` *or* `false`.

:memo: *The date of application input must be in DD-MM-YY format. If the date of application is 31 December 2020, input* `doa/31-12-20`.
</div>
<br>
Examples:

* `add can n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 t/DogGroomer exp/1 doa/16-10-20`
* `add can n/Betsy Crowe e/betsycrowe@example.com a/NUS Temasek Hall p/92920033 t/HR t/OfficeLady exp/5 doa/10-10-20 link/BetsyCrowe.com bl/false sal/3000`

### Adding a job listing: `add job`

If you are informed of a job opening and you would like to add it in CANdidates, you can add him into the list using the command below.

Format: `add job n/JOB_TITLE c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS v/VACANCY [t/JOB_DESCRIPTION]… [pr/PRIORITY]`

<div markdown="span" class="alert alert-primary">

:bulb: *A job can have 0 or more job description(s).*

:memo: *The priority input can be specified as* `pr/low`, `pr/moderate` *or* `pr/high`.

:memo: *If priority is not specified, it will be set to moderate by default.*
</div>
<br>
Examples:

* `add job n/Waiter c/Amelia’s Eating House p/98765432 e/ameliatjy@example.com a/Amelia Street, Block 123, #01-01 pr/low t/MultipleLocations v/1`
* `add job n/Delivery Man c/FedEx e/fedex@example.com a/Joo Koon p/93333222 pr/high t/delivery t/west v/10`

### Listing all candidates: `list can`

To accurately reflect the latest changes of candidates in the application, you can refresh the list of candidates using the format below.

Format: `list can`

<div markdown="span" class="alert alert-primary">

:exclamation: *On the application, be sure to click on the “Candidates” tab to view the list of candidates.*

:bulb: *This command is usually used after a* [sort can](#sorting-all-candidates-find-can) *command.*
</div>
<br>

### Listing all jobs: `list job`

To accurately reflect the latest changes of jobs in the application, you can refresh the job listings using the format below.

Format: `list job`

<div markdown="span" class="alert alert-primary">

:exclamation: *On the application, be sure to click on the “Jobs” tab to view the job listings.*

:bulb: *This command is usually used after a* [sort job](#sorting-all-jobs-find-job) *command.*
</div>
<br>

### Editing a candidate: `edit can`

Edits an existing candidate in the candidate list.

Format: `edit can INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/JOB_TYPE]…`

* Edits the candidate at the specified `INDEX`. The index refers to the index number shown in the displayed candidate list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing job type tags, the existing tags of the candidate will be removed i.e adding of tags is not cumulative.
* You can remove all the candidate’s tags by typing `t/` without
    specifying any tags after it.

Examples:

*  `edit 1 p/91234567 e/johndoe@example.com` <br>
Edits the phone number and email address of the 1st candidate to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` <br>
Edits the name of the 2nd candidate to be `Betsy Crower` and clears all existing tags.

### Editing a job: `edit job`

Edits an existing job in the job list.

Format: `edit job INDEX [n/JOB_TITLE] [c/COMPANY_NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [pr/PRIORITY] [t/JOB_DESCRIPTION]…`

* Edits the job at the specified `INDEX`. The index refers to the index number shown in the displayed job list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing job type tags, the existing tags of the job will be removed i.e adding of tags is not cumulative.
* You can remove all the job’s tags by typing `t/` without specifying any tags after it.
* Priority of job can be specified as low, moderate or high.

Examples:

*  `edit job 2 c/Dog Cafe p/82827731 a/Dog Street pr/high` <br>
Edits the job company name, phone number, address and priority of
the 2nd job to be Dog Cafe, 82827731, Dog Street and high respectively.

### Deleting a candidate: `delete can`

Deletes the specified candidate from the candidate list.

Format: `delete can INDEX`

* Deletes the candidate at the specified `INDEX`.
* The index refers to the index number shown in the displayed candidate list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list can` followed by `delete can 2` deletes the 2nd candidate in the candidate list.

### Deleting a job: `delete job`

Deletes the specified job from the job listing.

Format: `delete job INDEX`

* Deletes the job at the specified `INDEX`.
* The index refers to the index number shown in the displayed candidate list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list job` followed by `delete job2` deletes the 2nd job in the job list.

### Clearing all candidate entries: `clear can`

Clears all entries from the candidate list.

Format: `clear can`

### Clearing all job entries: `clear job`

Clears all entries from the job list.

Format: `clear job`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

All data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.


--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous CANdidates home folder.

**Q**: How do I report a bug I encountered?<br>
**A**: Send an email to developers@CANdidates.com with a description and screenshot (if relevant) of the bug. We will get back to you promptly.

**Q**: How can I contribute to this project?<br>
**A**: You may create a pull request to this [repository](https://github.com/AY2021S1-CS2103T-T17-3/tp). Our [developer's guide](https://ay2021s1-cs2103t-t17-3.github.io/tp/DeveloperGuide.html) for your reference.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Candidate Format | Job Format
--------|------------------|------------------
**Add** | `add can n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS exp/YEARS_OF_EXPERIENCE doa/DATE_OF_APPLICATION [t/JOB_TYPE]…​ [sal/EXPECTED_SALARY] [bl/IS_BLACKLISTED] [link/PROFILE_LINK]` | `add job n/JOB_TITLE c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS v/VACANCY [t/JOB_DESCRIPTION]… [pr/PRIORITY]`
**Clear** | `clear can` | `clear job`
**Delete** | `delete can INDEX` | `delete job INDEX`
**Edit** | `edit can INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/JOB_TYPE]…​` | `edit job INDEX [n/JOB_TITLE] [c/COMPANY_NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [pr/PRIORITY] [t/JOB_DESCRIPTION]…​`
**List** | `list can` | `list job`
**Help** | `help` | `help`
**Exit** | `exit` | `exit`

--------------------------------------------------------------------------------------------------------------------

## Glossary

Terms | Explanation
--------|------------------------------------
**Java** | Java is a widely-used programming language that developers use to create applications on computers.
**GUI** | A GUI (Graphical User Interface) is a system of interactive visual components for computer software. It is the visible component of the software.
**Parameter** | Input to the command that the user specifies.
**Cumulative** | Increasing in quantity.
**Hard disk** | Storage of information in a computer.
**Repository** | Online container where your code can be stored, contributed to and managed over time.
**Pull Request** | Formal request to merge one’s code into a larger codebase.
