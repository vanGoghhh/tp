---
layout: page
title: User Guide
---

CANdidates is a powerful and optimized contact management
app for job recruiters to manage job applicants and job listings.

## Table of Contents

* [Quick start](#quick-start)
* [Features](#features)
     * [Viewing help: help](#viewing-help-help)
     * [Adding a candidate: add can](#adding-a-candidate-coming-soon-add-can)
     * [Adding a job listing: add job](#adding-a-job-listing-coming-soon-add-job)
     * [Listing all candidates: list can](#listing-all-candidates-coming-soon-list-can)
     * [Listing all jobs: list job](#listing-all-jobs-coming-soon-list-job)
     * [Editing a candidate: edit can](#editing-a-candidate-coming-soon-edit-can)
     * [Editing a job: edit job](#editing-a-job-coming-soon-edit-job)
     * [Deleting a candidate: delete can](#deleting-a-candidate-coming-soon-delete-can)
     * [Deleting a job: delete job](#deleting-a-job-coming-soon-delete-job)
     * [Clearing all candidate entries: clear can](#clearing-all-candidate-entries-coming-soon-clear-can)
     * [Clearing all job entries: clear job](#clearing-all-job-entries-coming-soon-clear-job)
     * [Exiting the program : exit](#exiting-the-program--exit)
     * [Saving the data](#saving-the-data)
* [FAQ](#faq)
* [Command summary](#command-summary)


--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `candidates.jar` from [here]() [coming soon].

1. Copy the file to the folder you want to use as the _home folder_ for your CANdidates.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list can`** : Lists all candidates.

   * **`add can`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a candidate named `John Doe` to the candidate list.

   * **`delete can`**`3` : Deletes the 3rd candidate shown in the current candidate list.

   * **`clear can`** : Deletes all candidates.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/JOB_TYPE]` can be used as `n/John Doe t/programmer` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/JOB_TYPE]…​` can be used as ` ` (i.e. 0 times), `t/accountant`, `t/programmer t/technician` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>

### Viewing help: `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a candidate: `add can`

Adds a candidate to the candidate list.

Format: `add can n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/JOB_TYPE]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A candidates can have any number of job type tags (including 0)
</div>
<br>
Examples:

* `add can n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 t/Dog Groomer`
* `add can n/Betsy Crowe e/betsycrowe@example.com a/NUS Temasek Hall p/92920033 t/HR t/Office Lady`

### Adding a job listing: `add job`

Adds a job to the job listings.

Format: `add job n/JOB_TITLE c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [pr/PRIORITY] [t/JOB_DESCRIPTION]… `

* Priority can be specified as low, moderate or high.
* Priority is an optional field and default priority for jobs is moderate unless specified otherwise.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A job can have any number of job type tags (including 0)
</div>
<br>
Examples:

* `add job n/Waiter c/Amelia’s Eating House p/98765432 e/ameliatjy@example.com a/Amelia Street, Block 123, #01-01 pr/low t/MultipleLocations`
* `add job n/Delivery Man c/FedEx e/fedex@example.com a/Joo Koon p/93333222 pr/high`

### Listing all candidates: `list can`

Shows a list of all candidates in the candidates listing.

Format: `list can`

### Listing all jobs: `list job`

Shows a list of all jobs in the jobs listing.

Format: `list job`

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

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Candidate Format | Job Format
--------|------------------|------------------
**Add** | `add can n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/JOB_TYPE]…​` | `add job n/JOB_TITLE c/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [pr/PRIORITY] [t/JOB_DESCRIPTION]…​`
**Clear** | `clear can` | `clear job`
**Delete** | `delete can INDEX` | `delete job INDEX`
**Edit** | `edit can INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/JOB_TYPE]…​` | `edit job INDEX [n/JOB_TITLE] [c/COMPANY_NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [pr/PRIORITY] [t/JOB_DESCRIPTION]…​`
**List** | `list can` | `list job`
**Help** | `help` | `help`
**Exit** | `exit` | `exit`
