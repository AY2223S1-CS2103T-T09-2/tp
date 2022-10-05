package seedu.address.model.pet;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

public class Pet {

    private final Name name;
    private final Person owner;
    private final Color color;
    private final DateOfBirth dateOfBirth;
    private final Species species;
    private final Weight weight;
    private final Height height;
    private final VaccinationStatus vaccinationStatus;
    private final Set<Tag> tags = new HashSet<>();
    private final Set<PetCertificate> certificates = new HashSet<>();

    public Pet(Name name,
               Person owner,
               Color color,
               DateOfBirth dateOfBirth,
               Species species,
               Weight weight,
               Height height,
               VaccinationStatus vaccinationStatus,
               Set<Tag> tags,
               Set<PetCertificate> certificates) {
        requireAllNonNull(name, owner, color, dateOfBirth, species, weight, height, vaccinationStatus);
        this.name = name;
        this.owner = owner;
        this.color = color;
        this.dateOfBirth = dateOfBirth;
        this.species = species;
        this.weight = weight;
        this.height = height;
        this.vaccinationStatus = vaccinationStatus;
        this.tags.addAll(tags);
        this.certificates.addAll(certificates);
    }

    public Pet(Name name,
               Color color,
               String dateOfBirthString,
               Species species,
               Weight weight,
               Height height,
               Set<Tag> tags,
               Set<PetCertificate> certificates) throws IllegalValueException {
        this(name,
                null,
                color,
                DateOfBirth.parseString(dateOfBirthString),
                species,
                weight,
                height,
                VaccinationStatus.defaultStatus(),
                tags,
                certificates);
    }

    public Pet(Name name,
               Color color,
               DateOfBirth dateOfBirth,
               Species species,
               Weight weight,
               Height height) {
        this(name,
                null,
                color,
                dateOfBirth,
                species,
                weight,
                height,
                VaccinationStatus.defaultStatus(),
                null,
                null);
    }

    public Pet(Name name,
               Color color,
               String dateOfBirthString,
               Species species,
               Weight weight,
               Height height) throws IllegalValueException {
        this(name,
                color,
                DateOfBirth.parseString(dateOfBirthString),
                species,
                weight,
                height);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Species: ")
                .append(getSpecies())
                .append("; Date Of Birth: ")
                .append(getDateOfBirth().toString())
                .append("; Weight: ")
                .append(getWeight())
                .append("; Height: ")
                .append(getHeight())
                .append("; Color: ")
                .append(getColor())
                .append("; ")
                .append(getVaccinationStatus());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }

        Set<PetCertificate> certificates = getCertificates();
        if (!certificates.isEmpty()) {
            builder.append("; Certificates: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }

    /**
     * Returns true if both sets have the same name.
     * This defines a weaker notion of equality between two pets.
     */
    public boolean isSamePerson(Pet otherPet) {
        if (otherPet == this) {
            return true;
        }

        return otherPet != null
                && otherPet.getName().equals(getName());
    }

    /**
     * Returns true if both pets have the same identity and data fields.
     * This defines a stronger notion of equality between two pets.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Pet)) {
            return false;
        }

        Pet otherPet = (Pet) other;
        return otherPet.getName().equals(getName())
                && otherPet.getColor().equals(getColor())
                && otherPet.getDateOfBirth().equals(getDateOfBirth())
                && otherPet.getHeight().equals(getHeight())
                && otherPet.getWeight().equals(getWeight())
                && otherPet.getSpecies().equals(getSpecies())
                && otherPet.getVaccinationStatus().equals(getVaccinationStatus())
                && otherPet.getCertificates().equals(getCertificates())
                && ((otherPet.getOwner() == null && getOwner() == null)
                || (otherPet.getOwner() != null && otherPet.getHeight().equals(getHeight())))
                && otherPet.getTags().equals(getTags());
    }

    /**
     * Returns a combination of hash codes of all instance objects.
     * Use this method for custom fields hashing instead of implementing your own
     *
     * @return a hash code representing this pet.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, color, dateOfBirth, species, weight, height, vaccinationStatus, tags,
                certificates, owner);
    }

    public Name getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public Height getHeight() {
        return height;
    }

    public Person getOwner() {
        return owner;
    }

    public Species getSpecies() {
        return species;
    }

    public Weight getWeight() {
        return weight;
    }

    public VaccinationStatus getVaccinationStatus() {
        return vaccinationStatus;
    }

    /**
     * Returns an immutable pet certificate set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<PetCertificate> getCertificates() {
        return Collections.unmodifiableSet(certificates);
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }
}
