package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.information.Address;
import seedu.address.model.information.Email;
import seedu.address.model.information.Job;
import seedu.address.model.information.Name;
import seedu.address.model.information.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Job objects.
 */
public class JobBuilder {

    public static final String DEFAULT_JOB_TITLE = "Teaching Assistant";
    public static final String DEFAULT_COMPANY_NAME = "NUS";
    public static final String DEFAULT_PHONE = "65355255";
    public static final String DEFAULT_EMAIL = "TA@nus.edu.sg";
    public static final String DEFAULT_ADDRESS = "21 Lower Kent Ridge Rd, Singapore 119077";

    private Name jobTitle;
    private Name companyName;
    private Phone phone;
    private Email email;
    private Address address;
    private Set<Tag> tags;

    /**
     * Creates a {@code Job} with the default details.
     */
    public JobBuilder() {
        jobTitle = new Name(DEFAULT_JOB_TITLE);
        companyName = new Name(DEFAULT_COMPANY_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
    }

    /**
     * Initializes the JobBuilder with the data of {@code jobToCopy}.
     */
    public JobBuilder(Job jobToCopy) {
        jobTitle = jobToCopy.getJobTitle();
        companyName = jobToCopy.getCompanyName();
        phone = jobToCopy.getPhone();
        email = jobToCopy.getEmail();
        address = jobToCopy.getAddress();
        tags = new HashSet<>(jobToCopy.getTags());
    }

    /**
     * Sets the {@code jobTitle} of the {@code Job} that we are building.
     */
    public JobBuilder withJobTitle(String jobTitle) {
        this.jobTitle = new Name(jobTitle);
        return this;
    }

    /**
     * Sets the {@code companyName} of the {@code Job} that we are building.
     */
    public JobBuilder withCompanyName(String companyName) {
        this.companyName = new Name(companyName);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Job} that we are building.
     */
    public JobBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Job} that we are building.
     */
    public JobBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Job} that we are building.
     */
    public JobBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Job} that we are building.
     */
    public JobBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public Job build() {
        return new Job(jobTitle, companyName, phone, email, address, tags);
    }

}
