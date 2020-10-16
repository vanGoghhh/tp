package seedu.address.model.util;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.JobAddressBook;
import seedu.address.model.PersonAddressBook;
import seedu.address.model.ReadOnlyJobAddressBook;
import seedu.address.model.ReadOnlyPersonAddressBook;
import seedu.address.model.information.Address;
import seedu.address.model.information.Email;
import seedu.address.model.information.Experience;
import seedu.address.model.information.Job;
import seedu.address.model.information.Name;
import seedu.address.model.information.Person;
import seedu.address.model.information.Phone;
import seedu.address.model.information.Priority;
import seedu.address.model.information.Salary;
import seedu.address.model.information.UrlLink;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code PersonAddressBook}
 * or {@code JobAddressBook} with sample data .
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                    new Experience("0"), Optional.of(new Address("Blk 30 Geylang Street 29, #06-40")),
                    Optional.empty(), Optional.empty(), getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                    new Experience("0.5"), Optional.of(new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18")),
                Optional.of(new UrlLink("Google.com")), Optional.of(new Salary("8800")),
                    getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                    new Experience("1.0"), Optional.of(new Address("Blk 11 Ang Mo Kio Street 74, #11-04")),
                    Optional.of(new UrlLink("Github.com")), Optional.of(new Salary("1800")),
                    getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                    new Experience("1.5"), Optional.of(new Address("Blk 436 Serangoon Gardens Street 26, #16-43")),
                    Optional.of(new UrlLink("linkedin.com")), Optional.empty(),
                    getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                    new Experience("2.0"), Optional.of(new Address("Blk 47 Tampines Street 20, #17-35")),
                    Optional.of(new UrlLink("Tinder.com")), Optional.of(new Salary("2800")),
                    getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                    new Experience("10"), Optional.of(new Address("Blk 45 Aljunied Street 85, #11-31")),
                    Optional.of(new UrlLink("myprofile.com")), Optional.of(new Salary("25000")),
                    getTagSet("colleagues"))
        };
    }

    public static Job[] getSampleJobs() {
        return new Job[] {
            new Job(new Name("Toilet Bowl Cleaner"), new Name("Facebook"), new Phone("67438807"),
                new Email("recruitment@facebook.com"), new Address("1 Hacker Way, Menlo Park, CA 94025"),
                getTagSet("Cleaner"), new Priority("low")),
            new Job(new Name("Wall Painter"), new Name("Apple"), new Phone("69272758"),
                new Email("recruitment@apple.com"), new Address("1 Apple Park Way, Cupertino, California"),
                getTagSet("Cleaner"), new Priority("moderate")),
            new Job(new Name("Plant Waterer"), new Name("Amazon"), new Phone("63210283"),
                new Email("recruitment@amazon.com"), new Address("16 Forest Way, Seattle, Washington"),
                getTagSet("Cleaner"), new Priority("moderate")),
            new Job(new Name("Glass Wiper"), new Name("Netflix"), new Phone("61031282"),
                new Email("recruitment@netflix.com"), new Address("19 Netflix Lane, Los Gatos, California"),
                getTagSet("Cleaner"), new Priority("moderate")),
            new Job(new Name("Software Engineer"), new Name("Google"), new Phone("62492021"),
                new Email("recruitment@google.com"), new Address("1600 Google Way, Mountain View, California"),
                getTagSet("SE"), new Priority("high")),
            new Job(new Name("CS2103T Lecturer"), new Name("NUS"), new Phone("62624417"),
                new Email("recruitment@nus.edu.sg"), new Address("21 Lower Kent Ridge Rd, Singapore 119077"),
                getTagSet("Teaching"), new Priority("high"))
        };
    }

    public static ReadOnlyPersonAddressBook getSamplePersonAddressBook() {
        PersonAddressBook samplePAb = new PersonAddressBook();
        for (Person samplePerson : getSamplePersons()) {
            samplePAb.addPerson(samplePerson);
        }
        return samplePAb;
    }

    public static ReadOnlyJobAddressBook getSampleJobAddressBook() {
        JobAddressBook sampleJAb = new JobAddressBook();
        for (Job sampleJob : getSampleJobs()) {
            sampleJAb.addJob(sampleJob);
        }
        return sampleJAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
