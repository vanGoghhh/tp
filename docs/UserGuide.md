---
layout: page
title: User Guide
---

## CANdidates User Guide

1. [Introduction](#introduction)
     1. [Author](#authors)
1. [Preface](#preface)
     1. [Understanding Symbols](#understanding-symbols)
     1. [Understanding Input Fields](#understanding-input-fields)
2. [Quick Start](#quick-start)
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
     1. [Sorting all candidates: sort can](#sorting-all-candidates-sort-can)
     1. [Sorting all jobs: sort job](#sorting-all-jobs-sort-job)
     1. [Deleting a candidate: delete can](#deleting-a-candidate-delete-can)
     1. [Deleting a job: delete job](#deleting-a-job-delete-job)
     1. [Clearing all candidate entries: clear can](#clearing-all-candidate-entries-clear-can)
     1. [Clearing all job entries: clear job](#clearing-all-job-entries-clear-job)
     1. [Exiting the program : exit](#exiting-the-program--exit)
     1. [Saving the data](#saving-the-data)
1. [FAQ](#faq)
1. [Command Summary](#command-summary)
1. [Glossary](#glossary)

--------------------------------------------------------------------------------------------------------------------

## Introduction
Hello there! If you are reading this, you must be curious about CANdidates. 

CANdidates is a powerful and optimized contact management app for job recruiters to manage job candidates and job listings. 
A key strength of CANdidates is its convenience and ease of managing all job-related contacts in a single application. 

If you find yourself having difficulty in managing job candidates and positions, then CANdidates is the perfect tool for you! 
Use this user guide to discover the amazing functions and features of CANdidates! 
Although CANdidates is simple and intuitive enough to use without having to read this user guide, 
we still recommend that you read through in order to fully utilise CANdidates. 

Before you get thrown off by some of the more technical terms used in this user guide, 
you may be happy to know that a glossary is provided at the end of this document and may be of help to you!

### Authors
CANdidates is developed as part of a NUS CS2103T Project by:

* [Amelia Tan Jin Yu](team/ameliatjy.md)
* [Lee Joon Jie](team/breadpeanutbutter.md)
* [Nigel Ng Yong Sheng](team/vangoghhh.md)
* [Tan Yu Ting, Germaine](team/g-erm.md)
* [Toh Hong Xian](team/raythx98.md)

--------------------------------------------------------------------------------------------------------------------

## Preface
For a smoother start to your usage of CANdidates, read this section to find out how this document is structured, 
how to navigate the document, and what all the symbols and special fonts mean.

### Understanding Symbols
This section will explain all the symbols and fonts used in this document.

Symbols/Font  | Explanation
--------------|------------------------------------
**`command`** | A grey highlight means that you can type the words into CANdidates and it will start performing tasks.
:sushi:       | Food for thought.
:black_nib:   | This gives an example of how to use the feature.
:memo:        | This gives additional comments on the feature being explained.
:bulb:        | There are additional tips that you can make use of when using the explained feature.
:exclamation: | These are precautions you need to take note of when using the application.

### Understanding Input Fields
Input fields are fields that you have to specify in your commands. Still not sure what this means without context? 
Try getting a quick glance at [Quick Start](#quick-start) and [Features](#features) sections first!

You may refer back to this table whenever you need help understanding the input fields.

Name of input field   | How you can use them
----------------------|------------------------------------
`NAME`                | Name of candidate being added or edited.
`PHONE_NUMBER`        | Contact number of candidate or job listing being added or edited.
`EMAIL`               | Contact email address of candidate or job listing being added or edited.
`ADDRESS`             | Residential address of candidate or address of workplace for the job listing.
`YEARS_OF_EXPERIENCE` | Years of experience of the candidate in the relevant field one applied for.
`DATE_OF_APPLICATION` | Date of job application submitted, in the format of DD-MM-YY
`EXPECTED_SALARY`     | If a candidate expects a certain amount of salary, it can be specified using this field.
`IS_BLACKLISTED`      | You may use this to blacklist candidates that are unresponsive, have poor attitude, etc. You can use this to sort or filter candidates. <br> :exclamation: This field only accepts 2 specific values: true or false.
`PROFILE_LINK`        | URL link to candidate profile or portfolio (e.g. LinkedIn or GitHub, etc.) to provide convenience for you to refer to their profile later on.
`JOB_TYPE`            | You can include job type tags for candidates so that it will be easier to find candidates applying for similar jobs later on. For example, you can tag them according to the job industry.
`JOB_TITLE`           | Title of a job position.
`COMPANY_NAME`        | Name of the company for the job listing you are adding or editing.
`VACANCY`             | Vacancy of a job listing i.e. Number of available slots open for hiring.
`PRIORITY`            | Job listings may be of different urgency levels. For better categorisation, you may specify the priority of a job listing.<br> :exclamation: This field only accepts 3 specific values: low, moderate or high.
`JOB_DESCRIPTION`     | You can include job description tags for job listings to specify additional description for it. For example, you may wish to specify restrictions on the listing such as age or gender.
`FIELD_TO_SORT`       | Input field that is exclusive for [sort can](#sorting-all-candidates-sort-can) and [sort job](#sorting-all-jobs-sort-job) commands, to specify the field that the candidate or job list is being sorted by. <br>:exclamation: This field only takes in specific values described in the respective feature sections.
`ORDER`               | Input field that is exclusive for [sort can](#sorting-all-candidates-sort-can) and [sort job](#sorting-all-jobs-sort-job) commands, to specify the sort order. :exclamation: This field only accepts 2 specific values: asc or desc.
`INDEX`               | Index number of the candidate or job displayed in the list.
--------------------------------------------------------------------------------------------------------------------

## Quick Start
Can’t wait to start using CANdidates? This section guides you through the starting up process, so that you can proceed on to use the application for your own needs!

1. Download the latest `candidates.jar` from [here](https://github.com/AY2021S1-CS2103T-T17-3/tp/blob/master/docs).

1. Copy the file to the folder you want to use as the _home folder_ for your CANdidates.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list can`** : Lists all candidates.

   * **`add can`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 exp/5 doa/15-10-20` : Adds a candidate named 'John Doe' with phone number '98765432', email 'johnd@example.com', address 'John street, block 123, #01-01', years of experience '5' and date of application '15th October 2020' to the candidate list.

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
This exciting section describes all the amazing features we have in CANdidates for your utmost convenience!

<div markdown="block" class="alert alert-info">

:memo: Before we jump right into the details of each feature, here are some notes about the command format so that you can understand the features better:<br>

* Words in `UPPER_CASE` are the input fields which are supposed to be specified by you.<br>
  e.g. in `add n/NAME`, `NAME` is a input field which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `c/COMPANY_NAME [t/JOB_DESCRIPTION]` can be used as `c/Samsung t/ContractWorker` or just `c/Samsung`.

* Items with `…` after them can be used multiple times including zero times. You can put as much information as you want to!<br>
  e.g. `[t/JOB_TYPE]…` can be used as ` ` (i.e. 0 times), `t/accountant` (i.e. 1 time), `t/programmer t/technician` (i.e. 2 times) etc.

* Input fields can be in any order you want them to be.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

*:bulb: If you are confused with the various input fields, refer to [Understanding Input Fields](#understanding-input-fields).*
</div>

### Viewing help: `help`

If you are unsure of how to use the application, we have a help function that will direct you to our user guide!  You might also find it helpful to refer to the summary of all the available commands [here](#command-summary).

![help message](images/helpMessage.png)

Format: `help`

### Adding a candidate: `add can`

If you have a new candidate who approached you and you would like to put him in CANdidates, you can add him into the list using the command below.

Format: `add can n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS exp/YEARS_OF_EXPERIENCE doa/DATE_OF_APPLICATION [t/JOB_TYPE]…​ [sal/EXPECTED_SALARY] [bl/IS_BLACKLISTED] [link/PROFILE_LINK]`

<div markdown="span" class="alert alert-primary">

:bulb: *A candidate can have 0 or more job type(s)*.
<br>
:memo: *The blacklist input can be specified as* `bl/true` *or* `false`.
<br>
:memo: *The date of application input must be in DD-MM-YY format. If the date of application is 31 December 2020, input* `doa/31-12-20`.
</div>

**Examples:**

:black_nib: To add a candidates with name _John Doe_, phone _98765432_, email _johnd<span>@</span>example.com_, address _John street, block 123, #01-01_, job type _DogGroomer_, with _1_ year of experience who applied on _16 October 2020_,

    add can n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 
    t/DogGroomer exp/1 doa/16-10-20

:black_nib: To add a candidates with name _Betsy Crowe_, email _betsycrowe<span>@</span>example.com_, address _NUS Temasek Hall_, phone _92920033_,  job types _HR_ and _OfficeLady_, with _5_ years of experience who applied on _10 October 2020_, with profile link _BetsyCrowe.com_, who will _not be blacklisted_ with an expected salary of _3000_,

    add can n/Betsy Crowe e/betsycrowe@example.com a/NUS Temasek Hall p/92920033 
    t/HR t/OfficeLady exp/5 doa/10-10-20 link/BetsyCrowe.com bl/false sal/3000

### Adding a job listing: `add job`

If you are informed of a job opening and you would like to add it in CANdidates, you can add him into the list using the command below.

Format: `add job n/JOB_TITLE c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS v/VACANCY [t/JOB_DESCRIPTION]… [pr/PRIORITY]`

<div markdown="span" class="alert alert-primary">

:bulb: *A job can have 0 or more job description(s).*
<br>
:memo: *The priority input can be specified as* `pr/low`, `pr/moderate` *or* `pr/high`.
<br>
:memo: *If priority is not specified, it will be set to moderate by default.*
</div>

**Examples:**

:black_nib: To add a job with job title _Waiter_, company name _Amelia’s Eating House_, phone _98765432_, email _ameliatjy<span>@</span>example.com_, address _Amelia Street, Block 123, #01-01_, priority _low_, job description _MultipleLocations_ and with _1_ vacancy,

    add job n/Waiter c/Amelia’s Eating House p/98765432 e/ameliatjy@example.com 
    a/Amelia Street, Block 123, #01-01 pr/low t/MultipleLocations v/1

:black_nib: To add a job with job title _Delivery Man_, company name _FedEx_, email _fedex<span>@</span>example.com_, address _Joo Koon_,phone _93333222_, priority _high_, job descriptions _delivery_ and _west_, with _1_ vacancy,

    add job n/Delivery Man c/FedEx e/fedex@example.com a/Joo Koon p/93333222 
    pr/high t/delivery t/west v/10

### Listing all candidates: `list can`

To accurately reflect the latest changes of candidates in the application, you can refresh the list of candidates using the format below.

Format: `list can`

<div markdown="span" class="alert alert-primary">

:exclamation: *On the application, be sure to click on the “Candidates” tab to view the list of candidates.*

:bulb: *This command is usually used after a* [sort can](#sorting-all-candidates-sort-can) *or* [find can](#finding-a-candidate-find-can) *command to show the full list of candidates again.*
</div>
<br>

### Listing all jobs: `list job`

To accurately reflect the latest changes of jobs in the application, you can refresh the job listings using the format below.

Format: `list job`

<div markdown="span" class="alert alert-primary">

:exclamation: *On the application, be sure to click on the “Jobs” tab to view the job listings.*

:bulb: *This command is usually used after a* [sort job](#sorting-all-jobs-sort-job) *or* [find job](#finding-a-job-find-job) *command to show the full list of job listings again.*
</div>
<br>

### Editing a candidate: `edit can`

If you would like to edit the details of a particular candidate, you can use the command below

Format: `edit can INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [doa/DATE_OF_APPLICATION] [sal/EXPECTED_SALARY] [bl/IS_BLACKLISTED] [link/PROFILE_LINK] [t/JOB_TYPE]…`

<div markdown="span" class="alert alert-primary">

:memo: *Edits the candidate at the specified* `INDEX`. The `INDEX` refers to the index number shown in the displayed candidate list. The `INDEX` must be a positive integer 1, 2, 3, …​
<br>
:memo: *Existing values will be updated to the input values.*
<br>
:memo: *At least one of the optional fields must be provided.*
<br>
:memo: *The blacklist input can be specified as* `bl/true` *or* `bl/false`.
<br>
:exclamation: *When editing the job type, the existing job types will be cleared and replaced, i.e editing of job types is not cumulative even though there can be multiple job types.*
<br>
:bulb: *Certain optional candidate fields can be cleared by typing their respective prefixes without specifying any value after them. 
This works for the job type, address, expected salary and profile link fields. See the second example below for a demonstration.*

</div>

**Examples:**

:black_nib: To edit the 1st candidate’s phone number, email and blacklist status to be _91234567_, _johndoe<span>@</span>example.com_ and _true_ respectively,


    edit can 1 p/91234567 e/johndoe@example.com bl/true

:black_nib: To edit the 2nd candidate and clear existing job types, address, expected salary and profile link,

    edit can 2 t/ a/ sal/ link/ 

### Editing a job: `edit job`

If you would like to edit the details of a particular job, you can use the command below

Format: `edit job INDEX [n/JOB_TITLE] [c/COMPANY_NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [v/VACANCY] [pr/PRIORITY] [t/JOB_DESCRIPTION]…`

<div markdown="span" class="alert alert-primary">

:memo: *Edits the job at the specified* `INDEX`. The `INDEX` refers to the index number shown in the displayed job list. The `INDEX` must be a positive integer 1, 2, 3, …​
<br>
:memo: *Existing values will be updated to the input values.*
<br>
:memo: *At least one of the optional fields must be provided.*
<br>
:memo: *The priority input can be specified as* `pr/low`, `pr/moderate` *or* `pr/moderate`.
<br>
:exclamation: *When editing the job description, the existing job descriptions will be cleared and replaced, 
i.e editing of job descriptions is not cumulative even though there can be multiple job descriptions.*
<br>
:bulb: *Existing job descriptions can be cleared by typing t/ without specifying any value after it. 
See the second example below for a demonstration.*

</div>

**Examples:**

:black_nib: To edit the 2nd job’s company name, phone number, vacancy and priority to be _Dog Cafe_, _82827731_, _3_ and _high_ respectively,


    edit job 2 c/Dog Cafe p/82827731 v/3 pr/high

:black_nib: To edit the 3rd job and clear existing job descriptions, 

    edit job 3 t/



### Finding a candidate: `find can`

Too many candidates with different information? CANdidates provide you with a simple and quick way for you to find candidates who fulfil certain criteria(s) or even a specific candidate from the long list. All you have to do is tell CANdidates the field you are interested in, along with the keyword you are looking for!

Format: `find can [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [exp/YEARS_OF_EXPERIENCE] [doa/APPLICATION_DATE] [sal/EXPECTED_SALARY] [bl/IS_BLACKLISTED] [link/PROFILE_LINK] [t/JOB_TYPE]…`

<div markdown="span" class="alert alert-primary">
:memo: The search is case insensitive, e.g. john will match John

:memo: The order of the keywords does not matter, e.g. Doe John will match John Doe

:memo: For number fields (i.e. phone, years of experience and expected salary), only exact matching results will be displayed. For the remaining fields, results containing and exactly matching the keywords will be displayed.

:bulb: If you do not want to see blacklisted candidates in the list, you can use the command find can bl/false, the resulting list will show only non-blacklisted candidates.
</div>

**Examples:**

:black_nib: To find for candidates with tag(s) containing the word “_developer_” and an expected salary of exactly _$4000_,

    find can t/developer sal/4000

:black_nib: To find for _blacklisted_ candidates

    find can bl/true

### Finding a job: `find job`

Too many job listings with different information? Similar to the feature above, you can also find job listings by inserting keywords for the fields you are looking for!

Format: `find job [n/JOB_TITLE] [c/COMPANY_NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [pr/PRIORITY] [v/VACANCY] [t/JOB_DESCRIPTION]…`

<div markdown="span" class="alert alert-primary">
:memo: The search is case insensitive, e.g. samsung will match Samsung

:memo: The order of the keywords does not matter, e.g. King Burger will match Burger King

:memo: For number fields (i.e. phone and vacancy), only exact matching results will be displayed. For the remaining fields, results containing and exactly matching the keywords will be displayed.
</div>

**Examples:**

:black_nib: To find jobs with email containing “_@gmail.com_” and priority level _high_,

    find job e/@gmail.com pr/high

:black_nib: To find jobs with job titles containing the words “_Software Engineer_”,

    find job n/Software Engineer

### Sorting all candidates: `sort can`

You can view all the candidates in the order you wish to by typing in your desired order. Upon execution of the command, the sorted list of candidates would be displayed on the app!

Format: `sort can type/FIELD_TO_SORT order/ORDER`

<div markdown="span" class="alert alert-primary">
:exclamation: Both the type and order input must be supplied if not the list of candidates would not be sorted successfully

:memo: The type input must be one of  `type/exp`, `type/sal`, `type/bl` or `type/doa` depending on whether you wish to sort the candidates by their experience, expected salary, blacklist status or data of application respectively.

:memo: The order input must be specified as either `order/asc` or `order/desc` depending on whether you wish the sorting to be done in an ascending or descending manner.
</div>

**Examples:**

:black_nib: To sort the list of candidates starting from the lowest number of years of experience,

    sort can type/exp order/asc

:black_nib: To sort the list of candidates starting from the most recent application date,

    sort can type/doa order/desc

:black_nib: To view all blacklisted candidates followed by non-blacklisted candidates,

    sort can type/bl order/desc

### Sorting all jobs: `sort job`

Have too many job listings and need a way to organise them? You can get CANdidates to help you do that by sorting them according to the priority or vacancies you have indicated for the job listings!

Format: `sort job type/FIELD_TO_SORT order/ORDER`

<div markdown="span" class="alert alert-primary">
:memo: *The* `FIELD_TO_SORT` *can be either* `pr` *or* `v` *depending on whether you wish to sort the job listings by their priority level or number of vacancies.*

:memo: *If you provide more than one* `FIELD_TO_SORT` *or* `ORDER` *, only the last one will be taken in as input e.g.* `sort job type/pr order/asc type/v order/desc` *will sort the job listings according to vacancies in descending order.* 

:memo: *The* `ORDER` *can be either* `asc` *or* `desc` *depending on whether you wish the sorting to be done in an ascending or descending manner.*
</div>

**Examples:**

:black_nib: To sort the list of jobs starting from lowest priority,

    sort job type/pr order/asc

:black_nib: To sort the list of jobs starting from the highest number of vacancies,

    sort can type/v order/desc
    
Step by Step:

Step 1. Type sort job type/pr order/asc in the command box and press Enter.

Step 2. The CANdidates application will display the message “Successfully sorted jobs by priority in ascending order.”

Step 3. The application will show the sorted job list based on the sort condition given.

### Deleting a candidate: `delete can`

Have you successfully found a job for a candidate and you no longer need to keep his/her details in CANdidates? 
To delete a particular candidate from the list, you can use the command below.

Format: `delete can INDEX`

<div markdown="span" class="alert alert-primary">

:memo: *Deletes the candidate at the specified* `INDEX`. *The* `INDEX` *refers to the index number shown in the displayed job list. The* `INDEX` *must be a positive integer 1, 2, 3, …​*
<br>
:exclamation: *The specified candidate’s data will be cleared and this action is irreversible. 
Please ensure you do not require the candidate’s data anymore before performing this command.*

</div>

**Examples:**

:black_nib: To delete the candidate at index _1_,

    delete can 1

:black_nib: To delete the candidate at index _3_,

    delete can 3

### Deleting a job: `delete job`

Deletes the specified job from the job listing.

Format: `delete job INDEX`

<div markdown="span" class="alert alert-primary">

:memo: *Deletes the job at the specified* `INDEX`. *The* `INDEX` *refers to the index number shown in the displayed job list. The* `INDEX` *must be a positive integer 1, 2, 3, …​*
<br>
:exclamation: *The specified job’s data will be cleared and this action is irreversible. 
Please ensure you do not require the job’s data anymore before performing this command.*

</div>

**Examples:**

:black_nib: To delete the job at index _1_,

    delete job 1

:black_nib: To delete the job at index _3_,

    delete job 3

### Clearing all candidate entries: `clear can`

Want to clear all the candidates in the list quickly without having to delete one by one? Simply use the command below!

Format: `clear can`

<div markdown="span" class="alert alert-primary">

:exclamation: *All candidate data will be cleared and this action is irreversible. 
Please ensure you do not require the candidate list data anymore before performing this command.*
<br>
:bulb: *This command can be used to clear the sample data on CANdidates when you first downloaded it.*

</div>

### Clearing all job entries: `clear job`

Want to clear all the jobs in the list quickly without having to delete one by one? Simply use the command below!

Format: `clear job`

<div markdown="span" class="alert alert-primary">

:exclamation: *All job data will be cleared and this action is irreversible. 
Please ensure you do not require the job list data anymore before performing this command.*
<br>
:bulb: *This command can be used to clear the sample data on CANdidates when you first downloaded it.*

</div>

### Exiting the program : `exit`

Done with updating your information with CANdidates? Use this command to exit the program!

Format: `exit`

### Saving the data

All data is saved in the hard disk automatically after any command that changes the data. No need worry about having to save manually!

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous CANdidates home folder.

**Q**: How do I report a bug I encountered?<br>
**A**: Send an email to *developers@CANdidates.com* with a description and screenshot (if relevant) of the bug. We will make sure to get back to you promptly!

**Q**: How can I contribute to this project?<br>
**A**: You may create a pull request to this [repository](https://github.com/AY2021S1-CS2103T-T17-3/tp). Here is our [developer's guide](https://ay2021s1-cs2103t-t17-3.github.io/tp/DeveloperGuide.html) for your reference.

--------------------------------------------------------------------------------------------------------------------

## Command Summary

This handy command summary table provides you with all the possible commands for CANdidates at one glance.

Action | Candidate Format | Job Format
--------|------------------|------------------
**Help** | `help` | `help`
**Add** | `add can n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS exp/YEARS_OF_EXPERIENCE doa/DATE_OF_APPLICATION [t/JOB_TYPE]… [sal/EXPECTED_SALARY] [bl/IS_BLACKLISTED] [link/PROFILE_LINK]` | `add job n/JOB_TITLE c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS v/VACANCY [t/JOB_DESCRIPTION]… [pr/PRIORITY]`
**List** | `list can` | `list job`
**Edit** | `edit can INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [doa/DATE_OF_APPLICATION] [sal/EXPECTED_SALARY] [bl/IS_BLACKLISTED] [link/PROFILE_LINK] [t/JOB_TYPE]…` | `edit job INDEX [n/JOB_TITLE] [c/COMPANY_NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [v/VACANCY] [pr/PRIORITY] [t/JOB_DESCRIPTION]…`
**Find** | `find can [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [exp/EXPERIENCE] [doa/APPLICATION_DATE] [sal/EXPECTED_SALARY] [bl/IS_BLACKLISTED] [link/PROFILE_LINK] [t/JOB_TYPE]…` | `find job [n/JOB_TITLE] [c/COMPANY_NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [pr/PRIORITY] [v/VACANCY] [t/JOB_DESCRIPTION]…`
**Sort** | `sort can type/FIELD_TO_SORT ORDER/order` | `sort job type/FIELD_TO_SORT ORDER/order`
**Delete** | `delete can INDEX` | `delete job INDEX`
**Clear** | `clear can` | `clear job`
**Exit** | `exit` | `exit`

--------------------------------------------------------------------------------------------------------------------

## Glossary

Terms | Explanation
--------|------------------------------------
**Java** | Java is a widely-used programming language that developers use to create applications on computers.
**GUI** | A GUI (Graphical User Interface) is a system of interactive visual components for computer software. It is the visible component of the software.
**Input field** | Input to the command that the user specifies.
**Cumulative** | Increasing in quantity.
**Hard disk** | Storage of information in a computer.
**Repository** | Online container where your code can be stored, contributed to and managed over time.
**Pull Request** | Formal request to merge one’s code into a larger codebase.
**Bug** | A software bug is an error, flaw or fault in a computer program or system that causes it to produce an incorrect or unexpected result, or to behave in unintended ways.
**Developer's Guide** | A guide that includes extensive guidance and reference materials to aid the developer in creating applications and extensions 
