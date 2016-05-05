/*
 * Copyright 2016 BiblioLabs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.rometools.rome.feed.module;

import com.rometools.rome.feed.CopyFrom;
import com.rometools.rome.feed.impl.CopyFromHelper;
import com.rometools.rome.feed.impl.ObjectBean;
import com.rometools.utils.Lists;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Dublin Core Terms Module.
 * <p>
 *
 * @see <a href="http://dublincore.org/documents/dcmi-terms/#H2">Dublin Core Terms</a>.
 * @author Michael Atwood
 *
 */
public class DCTermsModuleImpl extends ModuleImpl implements DCTermsModule {

    private static final long serialVersionUID = 1L;

    private final ObjectBean objBean;
    private List<String> title;
    private List<String> creator;
    private List<DCSubject> subject;
    private List<String> description;
    private List<String> publisher;
    private List<String> contributors;
    private List<Date> date;
    private List<String> type;
    private List<String> format;
    private List<String> identifier;
    private List<String> source;
    private List<String> language;
    private List<String> relation;
    private List<String> coverage;
    private List<String> rights;

    private List<String> theAbstract;
    private List<String> accessRights;
    private List<String> accrualMethod;
    private List<String> accrualPeriodicity;
    private List<String> accrualPolicy;
    private List<String> alternative;
    private List<String> audience;
    private List<String> available;
    private List<String> bibliographicCitation;
    private List<String> conformsTo;
    private List<Date> created;
    private List<Date> dateAccepted;
    private List<Date> dateCopyrighted;
    private List<Date> dateSubmitted;
    private List<String> educationLevel;
    private List<String> extent;
    private List<String> hasFormat;
    private List<String> hasPart;
    private List<String> hasVersion;
    private List<String> instructionalMethod;
    private List<String> isFormatOf;
    private List<String> isPartOf;
    private List<String> isReferencedBy;
    private List<String> isReplacedBy;
    private List<String> isRequiredBy;
    private List<Date> issued;
    private List<String> isVersionOf;
    private List<String> license;
    private List<String> mediator;
    private List<String> medium;
    private List<String> modified;
    private List<String> provenance;
    private List<String> references;
    private List<String> replaces;
    private List<String> requires;
    private List<String> rightsHolder;
    private List<String> spatial;
    private List<String> tableOfContents;
    private List<String> temporal;
    private List<String> valid;

    /**
     * Properties to be ignored when cloning.
     */
    private static final Set<String> IGNORE_PROPERTIES = new HashSet<String>();

    /**
     * Unmodifiable Set containing the convenience properties of this class.
     * <p>
     * Convenience properties are mapped to Modules, for cloning the convenience properties can be
     * ignored as the will be copied as part of the module cloning.
     */
    public static final Set<String> CONVENIENCE_PROPERTIES = Collections.unmodifiableSet(IGNORE_PROPERTIES);

    static {
        IGNORE_PROPERTIES.add("title");
        IGNORE_PROPERTIES.add("creator");
        IGNORE_PROPERTIES.add("subject");
        IGNORE_PROPERTIES.add("description");
        IGNORE_PROPERTIES.add("publisher");
        IGNORE_PROPERTIES.add("contributor");
        IGNORE_PROPERTIES.add("date");
        IGNORE_PROPERTIES.add("type");
        IGNORE_PROPERTIES.add("format");
        IGNORE_PROPERTIES.add("identifier");
        IGNORE_PROPERTIES.add("source");
        IGNORE_PROPERTIES.add("language");
        IGNORE_PROPERTIES.add("relation");
        IGNORE_PROPERTIES.add("coverage");
        IGNORE_PROPERTIES.add("rights");

        IGNORE_PROPERTIES.add("theAbstract");
        IGNORE_PROPERTIES.add("accessRights");
        IGNORE_PROPERTIES.add("accrualMethod");
        IGNORE_PROPERTIES.add("accrualPeriodicity");
        IGNORE_PROPERTIES.add("accrualPolicy");
        IGNORE_PROPERTIES.add("alternative");
        IGNORE_PROPERTIES.add("audience");
        IGNORE_PROPERTIES.add("available");
        IGNORE_PROPERTIES.add("bibliographicCitation");
        IGNORE_PROPERTIES.add("conformsTo");
        IGNORE_PROPERTIES.add("contributor");
        IGNORE_PROPERTIES.add("created");
        IGNORE_PROPERTIES.add("dateAccepted");
        IGNORE_PROPERTIES.add("dateCopyrighted");
        IGNORE_PROPERTIES.add("dateSubmitted");
        IGNORE_PROPERTIES.add("educationLevel");
        IGNORE_PROPERTIES.add("extent");
        IGNORE_PROPERTIES.add("hasFormat");
        IGNORE_PROPERTIES.add("hasPart");
        IGNORE_PROPERTIES.add("hasVersion");
        IGNORE_PROPERTIES.add("instructionalMethod");
        IGNORE_PROPERTIES.add("isFormatOf");
        IGNORE_PROPERTIES.add("isPartOf");
        IGNORE_PROPERTIES.add("isReferencedBy");
        IGNORE_PROPERTIES.add("isReplacedBy");
        IGNORE_PROPERTIES.add("isRequiredBy");
        IGNORE_PROPERTIES.add("issued");
        IGNORE_PROPERTIES.add("isVersionOf");
        IGNORE_PROPERTIES.add("license");
        IGNORE_PROPERTIES.add("mediator");
        IGNORE_PROPERTIES.add("medium");
        IGNORE_PROPERTIES.add("modified");
        IGNORE_PROPERTIES.add("provenance");
        IGNORE_PROPERTIES.add("references");
        IGNORE_PROPERTIES.add("replaces");
        IGNORE_PROPERTIES.add("requires");
        IGNORE_PROPERTIES.add("rightsHolder");
        IGNORE_PROPERTIES.add("spatial");
        IGNORE_PROPERTIES.add("tableOfContents");
        IGNORE_PROPERTIES.add("temporal");
        IGNORE_PROPERTIES.add("valid");
    }

    /**
     * Default constructor. All properties are set to <b>null</b>.
     * <p>
     *
     */
    public DCTermsModuleImpl() {
        super(DCTermsModule.class, URI);
        objBean = new ObjectBean(DCTermsModule.class, this, CONVENIENCE_PROPERTIES);
    }

    /**
     * Returns the DublinCore module titles.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module title, an empty list if none.
     *
     */
    @Override
    public List<String> getTitles() {
        return title = Lists.createWhenNull(title);
    }

    /**
     * Sets the DublinCore module titles.
     * <p>
     *
     * @param titles the list of String representing the DublinCore module titles to set, an empty
     *            list or <b>null</b> if none.
     *
     */
    @Override
    public void setTitles(final List<String> titles) {
        title = titles;
    }

    /**
     * Gets the DublinCore module title. Convenience method that can be used to obtain the first
     * item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module title, <b>null</b> if none.
     */
    @Override
    public String getTitle() {
        return Lists.firstEntry(title);
    }

    /**
     * Sets the DublinCore module title. Convenience method that can be used when there is only one
     * title to set.
     * <p>
     *
     * @param title the DublinCore module title to set, <b>null</b> if none.
     *
     */
    @Override
    public void setTitle(final String title) {
        this.title = Lists.create(title);
    }

    /**
     * Returns the DublinCore module creator.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module creator, an empty list if none.
     *
     */
    @Override
    public List<String> getCreators() {
        return creator = Lists.createWhenNull(creator);
    }

    /**
     * Sets the DublinCore module creators.
     * <p>
     *
     * @param creators the list of String representing the DublinCore module creators to set, an
     *            empty list or <b>null</b> if none.
     *
     */
    @Override
    public void setCreators(final List<String> creators) {
        creator = creators;
    }

    /**
     * Gets the DublinCore module title. Convenience method that can be used to obtain the first
     * item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module title, <b>null</b> if none.
     */
    @Override
    public String getCreator() {
        return Lists.firstEntry(creator);
    }

    /**
     * Sets the DublinCore module creator. Convenience method that can be used when there is only
     * one creator to set.
     * <p>
     *
     * @param creator the DublinCore module creator to set, <b>null</b> if none.
     *
     */
    @Override
    public void setCreator(final String creator) {
        this.creator = Lists.create(creator);
    }

    /**
     * Returns the DublinCore module subjects.
     * <p>
     *
     * @return a list of DCSubject elements with the DublinCore module subjects, an empty list if
     *         none.
     *
     */
    @Override
    public List<DCSubject> getSubjects() {
        return subject = Lists.createWhenNull(subject);
    }

    /**
     * Sets the DublinCore module subjects.
     * <p>
     *
     * @param subjects the list of DCSubject elements with the DublinCore module subjects to set, an
     *            empty list or <b>null</b> if none.
     *
     */
    @Override
    public void setSubjects(final List<DCSubject> subjects) {
        subject = subjects;
    }

    /**
     * Gets the DublinCore module subject. Convenience method that can be used to obtain the first
     * item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module subject, <b>null</b> if none.
     */
    @Override
    public DCSubject getSubject() {
        return Lists.firstEntry(subject);
    }

    /**
     * Sets the DCSubject element. Convenience method that can be used when there is only one
     * subject to set.
     * <p>
     *
     * @param subject the DublinCore module subject to set, <b>null</b> if none.
     *
     */
    @Override
    public void setSubject(final DCSubject subject) {
        this.subject = Lists.create(subject);
    }

    /**
     * Returns the DublinCore module description.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module description, an empty list if
     *         none.
     *
     */
    @Override
    public List<String> getDescriptions() {
        return description = Lists.createWhenNull(description);
    }

    /**
     * Sets the DublinCore module descriptions.
     * <p>
     *
     * @param descriptions the list of String representing the DublinCore module descriptions to
     *            set, an empty list or <b>null</b> if none.
     *
     */
    @Override
    public void setDescriptions(final List<String> descriptions) {
        description = descriptions;
    }

    /**
     * Gets the DublinCore module description. Convenience method that can be used to obtain the
     * first item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module description, <b>null</b> if none.
     */
    @Override
    public String getDescription() {
        return Lists.firstEntry(description);
    }

    /**
     * Sets the DublinCore module description. Convenience method that can be used when there is
     * only one description to set.
     * <p>
     *
     * @param description the DublinCore module description to set, <b>null</b> if none.
     *
     */
    @Override
    public void setDescription(final String description) {
        this.description = Lists.create(description);
    }

    /**
     * Returns the DublinCore module publisher.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module publisher, an empty list if
     *         none.
     *
     */
    @Override
    public List<String> getPublishers() {
        return publisher = Lists.createWhenNull(publisher);
    }

    /**
     * Sets the DublinCore module publishers.
     * <p>
     *
     * @param publishers the list of String representing the DublinCore module publishers to set, an
     *            empty list or <b>null</b> if none.
     *
     */
    @Override
    public void setPublishers(final List<String> publishers) {
        publisher = publishers;
    }

    /**
     * Gets the DublinCore module title. Convenience method that can be used to obtain the first
     * item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module title, <b>null</b> if none.
     */
    @Override
    public String getPublisher() {
        return Lists.firstEntry(publisher);
    }

    /**
     * Sets the DublinCore module publisher. Convenience method that can be used when there is only
     * one publisher to set.
     * <p>
     *
     * @param publisher the DublinCore module publisher to set, <b>null</b> if none.
     *
     */
    @Override
    public void setPublisher(final String publisher) {
        this.publisher = Lists.create(publisher);
    }

    /**
     * Returns the DublinCore module contributor.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module contributor, an empty list if
     *         none.
     *
     */
    @Override
    public List<String> getContributors() {
        return contributors = Lists.createWhenNull(contributors);
    }

    /**
     * Sets the DublinCore module contributors.
     * <p>
     *
     * @param contributors the list of String representing the DublinCore module contributors to
     *            set, an empty list or <b>null</b> if none.
     *
     */
    @Override
    public void setContributors(final List<String> contributors) {
        this.contributors = contributors;
    }

    /**
     * Gets the DublinCore module contributor. Convenience method that can be used to obtain the
     * first item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module contributor, <b>null</b> if none.
     */
    @Override
    public String getContributor() {
        return Lists.firstEntry(contributors);
    }

    /**
     * Sets the DublinCore module contributor. Convenience method that can be used when there is
     * only one contributor to set.
     * <p>
     *
     * @param contributor the DublinCore module contributor to set, <b>null</b> if none.
     *
     */
    @Override
    public void setContributor(final String contributor) {
        contributors = Lists.create(contributor);
    }

    /**
     * Returns the DublinCore module date.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module date, an empty list if none.
     *
     */
    @Override
    public List<Date> getDates() {
        return date = Lists.createWhenNull(date);
    }

    /**
     * Sets the DublinCore module dates.
     * <p>
     *
     * @param dates the list of Date representing the DublinCore module dates to set, an empty list
     *            or <b>null</b> if none.
     *
     */
    @Override
    public void setDates(final List<Date> dates) {
        date = dates;
    }

    /**
     * Gets the DublinCore module date. Convenience method that can be used to obtain the first
     * item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module date, <b>null</b> if none.
     */
    @Override
    public Date getDate() {
        return Lists.firstEntry(date);
    }

    /**
     * Sets the DublinCore module date. Convenience method that can be used when there is only one
     * date to set.
     * <p>
     *
     * @param date the DublinCore module date to set, <b>null</b> if none.
     *
     */
    @Override
    public void setDate(final Date date) {
        this.date = Lists.create(date);
    }

    /**
     * Returns the DublinCore module type.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module type, an empty list if none.
     *
     */
    @Override
    public List<String> getTypes() {
        return type = Lists.createWhenNull(type);
    }

    /**
     * Sets the DublinCore module types.
     * <p>
     *
     * @param types the list of String representing the DublinCore module types to set, an empty
     *            list or <b>null</b> if none.
     *
     */
    @Override
    public void setTypes(final List<String> types) {
        type = types;
    }

    /**
     * Gets the DublinCore module type. Convenience method that can be used to obtain the first
     * item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module type, <b>null</b> if none.
     */
    @Override
    public String getType() {
        return Lists.firstEntry(type);
    }

    /**
     * Sets the DublinCore module type. Convenience method that can be used when there is only one
     * type to set.
     * <p>
     *
     * @param type the DublinCore module type to set, <b>null</b> if none.
     *
     */
    @Override
    public void setType(final String type) {
        this.type = Lists.create(type);
    }

    /**
     * Returns the DublinCore module format.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module format, an empty list if none.
     *
     */
    @Override
    public List<String> getFormats() {
        return format = Lists.createWhenNull(format);
    }

    /**
     * Sets the DublinCore module formats.
     * <p>
     *
     * @param formats the list of String representing the DublinCore module formats to set, an empty
     *            list or <b>null</b> if none.
     *
     */
    @Override
    public void setFormats(final List<String> formats) {
        format = formats;
    }

    /**
     * Gets the DublinCore module format. Convenience method that can be used to obtain the first
     * item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module format, <b>null</b> if none.
     */
    @Override
    public String getFormat() {
        return Lists.firstEntry(format);
    }

    /**
     * Sets the DublinCore module format. Convenience method that can be used when there is only one
     * format to set.
     * <p>
     *
     * @param format the DublinCore module format to set, <b>null</b> if none.
     *
     */
    @Override
    public void setFormat(final String format) {
        this.format = Lists.create(format);
    }

    /**
     * Returns the DublinCore module identifier.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module identifier, an empty list if
     *         none.
     *
     */
    @Override
    public List<String> getIdentifiers() {
        return identifier = Lists.createWhenNull(identifier);
    }

    /**
     * Sets the DublinCore module identifiers.
     * <p>
     *
     * @param identifiers the list of String representing the DublinCore module identifiers to set,
     *            an empty list or <b>null</b> if none.
     *
     */
    @Override
    public void setIdentifiers(final List<String> identifiers) {
        identifier = identifiers;
    }

    /**
     * Gets the DublinCore module identifier. Convenience method that can be used to obtain the
     * first item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module identifier, <b>null</b> if none.
     */
    @Override
    public String getIdentifier() {
        return Lists.firstEntry(identifier);
    }

    /**
     * Sets the DublinCore module identifier. Convenience method that can be used when there is only
     * one identifier to set.
     * <p>
     *
     * @param identifier the DublinCore module identifier to set, <b>null</b> if none.
     *
     */
    @Override
    public void setIdentifier(final String identifier) {
        this.identifier = Lists.create(identifier);
    }

    /**
     * Returns the DublinCore module source.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module source, an empty list if none.
     *
     */
    @Override
    public List<String> getSources() {
        return source = Lists.createWhenNull(source);
    }

    /**
     * Sets the DublinCore module sources.
     * <p>
     *
     * @param sources the list of String representing the DublinCore module sources to set, an empty
     *            list or <b>null</b> if none.
     *
     */
    @Override
    public void setSources(final List<String> sources) {
        source = sources;
    }

    /**
     * Gets the DublinCore module source. Convenience method that can be used to obtain the first
     * item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module source, <b>null</b> if none.
     */
    @Override
    public String getSource() {
        return Lists.firstEntry(source);
    }

    /**
     * Sets the DublinCore module source. Convenience method that can be used when there is only one
     * source to set.
     * <p>
     *
     * @param source the DublinCore module source to set, <b>null</b> if none.
     *
     */
    @Override
    public void setSource(final String source) {
        this.source = Lists.create(source);
    }

    /**
     * Returns the DublinCore module language.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module language, an empty list if none.
     *
     */
    @Override
    public List<String> getLanguages() {
        return language = Lists.createWhenNull(language);
    }

    /**
     * Sets the DublinCore module languages.
     * <p>
     *
     * @param languages the list of String representing the DublinCore module languages to set, an
     *            empty list or <b>null</b> if none.
     *
     */
    @Override
    public void setLanguages(final List<String> languages) {
        language = languages;
    }

    /**
     * Gets the DublinCore module language. Convenience method that can be used to obtain the first
     * item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module langauge, <b>null</b> if none.
     */
    @Override
    public String getLanguage() {
        return Lists.firstEntry(language);
    }

    /**
     * Sets the DublinCore module language. Convenience method that can be used when there is only
     * one language to set.
     * <p>
     *
     * @param language the DublinCore module language to set, <b>null</b> if none.
     *
     */
    @Override
    public void setLanguage(final String language) {
        this.language = Lists.create(language);
    }

    /**
     * Returns the DublinCore module relation.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module relation, an empty list if none.
     *
     */
    @Override
    public List<String> getRelations() {
        return relation = Lists.createWhenNull(relation);
    }

    /**
     * Sets the DublinCore module relations.
     * <p>
     *
     * @param relations the list of String representing the DublinCore module relations to set, an
     *            empty list or <b>null</b> if none.
     *
     */
    @Override
    public void setRelations(final List<String> relations) {
        relation = relations;
    }

    /**
     * Gets the DublinCore module relation. Convenience method that can be used to obtain the first
     * item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module relation, <b>null</b> if none.
     */
    @Override
    public String getRelation() {
        return Lists.firstEntry(relation);
    }

    /**
     * Sets the DublinCore module relation. Convenience method that can be used when there is only
     * one relation to set.
     * <p>
     *
     * @param relation the DublinCore module relation to set, <b>null</b> if none.
     *
     */
    @Override
    public void setRelation(final String relation) {
        this.relation = Lists.create(relation);
    }

    /**
     * Returns the DublinCore module coverage.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module coverage, an empty list if none.
     *
     */
    @Override
    public List<String> getCoverages() {
        return coverage = Lists.createWhenNull(coverage);
    }

    /**
     * Sets the DublinCore module coverages.
     * <p>
     *
     * @param coverages the list of String representing the DublinCore module coverages to set, an
     *            empty list or <b>null</b> if none.
     *
     */
    @Override
    public void setCoverages(final List<String> coverages) {
        coverage = coverages;
    }

    /**
     * Gets the DublinCore module coverage. Convenience method that can be used to obtain the first
     * item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module coverage, <b>null</b> if none.
     */
    @Override
    public String getCoverage() {
        return Lists.firstEntry(coverage);
    }

    /**
     * Sets the DublinCore module coverage. Convenience method that can be used when there is only
     * one coverage to set.
     * <p>
     *
     * @param coverage the DublinCore module coverage to set, <b>null</b> if none.
     *
     */
    @Override
    public void setCoverage(final String coverage) {
        this.coverage = Lists.create(coverage);
    }

    /**
     * Returns the DublinCore module rights.
     * <p>
     *
     * @return a list of Strings representing the DublinCore module rights, an empty list if none.
     *
     */
    @Override
    public List<String> getRightsList() {
        return rights = Lists.createWhenNull(rights);
    }

    /**
     * Sets the DublinCore module rights.
     * <p>
     *
     * @param rights the list of String representing the DublinCore module rights to set, an empty
     *            list or <b>null</b> if none.
     *
     */
    @Override
    public void setRightsList(final List<String> rights) {
        this.rights = rights;
    }

    /**
     * Gets the DublinCore module rights. Convenience method that can be used to obtain the first
     * item, <b>null</b> if none.
     * <p>
     *
     * @return the first DublinCore module rights, <b>null</b> if none.
     */
    @Override
    public String getRights() {
        return Lists.firstEntry(rights);
    }

    /**
     * Sets the DublinCore module rights. Convenience method that can be used when there is only one
     * rights to set.
     * <p>
     *
     * @param rights the DublinCore module rights to set, <b>null</b> if none.
     *
     */
    @Override
    public void setRights(final String rights) {
        this.rights = Lists.create(rights);
    }

    @Override
    public List<String> getAbstractList() {
        return theAbstract = Lists.createWhenNull(theAbstract);
    }

    @Override
    public void setAbstractList(List<String> abstractList) {
        this.theAbstract = abstractList;
    }

    @Override
    public String getAbstract() {
        return Lists.firstEntry(theAbstract);
    }

    @Override
    public void setAbstract(String theAbstract) {
        this.theAbstract = Lists.create(theAbstract);
    }

    @Override
    public List<String> getAccessRightsList() {
        return accessRights = Lists.createWhenNull(accessRights);
    }

    @Override
    public void setAccessRightsList(List<String> accessRightsList) {
        this.accessRights = accessRightsList;
    }

    @Override
    public String getAccessRights() {
        return Lists.firstEntry(accessRights);
    }

    @Override
    public void setAccessRights(String accessRights) {
        this.accessRights = Lists.create(accessRights);
    }

    @Override
    public List<String> getAccrualMethods() {
        return accrualMethod = Lists.createWhenNull(accrualMethod);
    }

    @Override
    public void setAccrualMethods(List<String> accrualMethods) {
        this.accrualMethod = accrualMethods;
    }

    @Override
    public String getAccrualMethod() {
        return Lists.firstEntry(accrualMethod);
    }

    @Override
    public void setAccrualMethod(String accrualMethod) {
        this.accrualMethod = Lists.create(accrualMethod);
    }

    @Override
    public List<String> getAccrualPeriodicityList() {
        return accrualPeriodicity = Lists.createWhenNull(accrualPeriodicity);
    }

    @Override
    public void setAccrualPeriodicityList(List<String> accrualPeriodicityList) {
        this.accrualPeriodicity = accrualPeriodicityList;
    }

    @Override
    public String getAccrualPeriodicity() {
        return Lists.firstEntry(accrualPeriodicity);
    }

    @Override
    public void setAccrualPeriodicity(String accrualPeriodicity) {
        this.accrualPeriodicity = Lists.create(accrualPeriodicity);
    }

    @Override
    public List<String> getAccrualPolicyList() {
        return accrualPolicy = Lists.createWhenNull(accrualPolicy);
    }

    @Override
    public void setAccrualPolicyList(List<String> accrualPolicyList) {
        this.accrualPolicy = accrualPolicyList;
    }

    @Override
    public String getAccrualPolicy() {
        return Lists.firstEntry(accrualPolicy);
    }

    @Override
    public void setAccrualPolicy(String accrualPolicy) {
        this.accrualPolicy = Lists.create(accrualPolicy);
    }

    @Override
    public List<String> getAlternatives() {
        return alternative = Lists.createWhenNull(alternative);
    }

    @Override
    public void setAlternatives(List<String> alternatives) {
        this.alternative = alternatives;
    }

    @Override
    public String getAlternative() {
        return Lists.firstEntry(alternative);
    }

    @Override
    public void setAlternative(String alternative) {
        this.alternative = Lists.create(alternative);
    }

    @Override
    public List<String> getAudiences() {
        return audience = Lists.createWhenNull(audience);
    }

    @Override
    public void setAudiences(List<String> audiences) {
        this.audience = audiences;
    }

    @Override
    public String getAudience() {
        return Lists.firstEntry(audience);
    }

    @Override
    public void setAudience(String audience) {
        this.audience = Lists.create(audience);
    }

    @Override
    public List<String> getAvailableList() {
        return available = Lists.createWhenNull(available);
    }

    @Override
    public void setAvailableList(List<String> availableList) {
        this.available = availableList;
    }

    @Override
    public String getAvailable() {
        return Lists.firstEntry(available);
    }

    @Override
    public void setAvailable(String available) {
        this.available = Lists.create(available);
    }

    @Override
    public List<String> getBibliographicCitations() {
        return bibliographicCitation = Lists.createWhenNull(bibliographicCitation);
    }

    @Override
    public void setBibliographicCitations(List<String> bibliographicCitations) {
        this.bibliographicCitation = bibliographicCitations;
    }

    @Override
    public String getBibliographicCitation() {
        return Lists.firstEntry(bibliographicCitation);
    }

    @Override
    public void setBibliographicCitation(String bibliographicCitation) {
        this.bibliographicCitation = Lists.create(bibliographicCitation);
    }

    @Override
    public List<String> getConformsToList() {
        return conformsTo = Lists.createWhenNull(conformsTo);
    }

    @Override
    public void setConformsToList(List<String> conformsToList) {
        this.conformsTo = conformsToList;
    }

    @Override
    public String getConformsTo() {
        return Lists.firstEntry(conformsTo);
    }

    @Override
    public void setConformsTo(String conformsTo) {
        this.conformsTo = Lists.create(conformsTo);
    }

    @Override
    public List<Date> getCreatedList() {
        return created = Lists.createWhenNull(created);
    }

    @Override
    public void setCreatedList(List<Date> createdList) {
        this.created = createdList;
    }

    @Override
    public Date getCreated() {
        return Lists.firstEntry(created);
    }

    @Override
    public void setCreated(Date created) {
        this.created = Lists.create(created);
    }

    @Override
    public List<Date> getDateAcceptedList() {
        return dateAccepted = Lists.createWhenNull(dateAccepted);
    }

    @Override
    public void setDateAcceptedList(List<Date> dateAcceptedList) {
        this.dateAccepted = dateAcceptedList;
    }

    @Override
    public Date getDateAccepted() {
        return Lists.firstEntry(dateAccepted);
    }

    @Override
    public void setDateAccepted(Date dateAccepted) {
        this.dateAccepted = Lists.create(dateAccepted);
    }

    @Override
    public List<Date> getDateCopyrightedList() {
        return dateCopyrighted = Lists.createWhenNull(dateCopyrighted);
    }

    @Override
    public void setDateCopyrightedList(List<Date> dateCopyrightedList) {
        this.dateCopyrighted = dateCopyrightedList;
    }

    @Override
    public Date getDateCopyrighted() {
        return Lists.firstEntry(dateCopyrighted);
    }

    @Override
    public void setDateCopyrighted(Date dateCopyrighted) {
        this.dateCopyrighted = Lists.create(dateCopyrighted);
    }

    @Override
    public List<Date> getDateSubmittedList() {
        return dateSubmitted = Lists.createWhenNull(dateSubmitted);
    }

    @Override
    public void setDateSubmittedList(List<Date> dateSubmittedList) {
        this.dateSubmitted = dateSubmittedList;
    }

    @Override
    public Date getDateSubmitted() {
        return Lists.firstEntry(dateSubmitted);
    }

    @Override
    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = Lists.create(dateSubmitted);
    }

    @Override
    public List<String> getEducationLevels() {
        return educationLevel = Lists.createWhenNull(educationLevel);
    }

    @Override
    public void setEducationLevels(List<String> educationLevels) {
        this.educationLevel = educationLevels;
    }

    @Override
    public String getEducationLevel() {
        return Lists.firstEntry(educationLevel);
    }

    @Override
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = Lists.create(educationLevel);
    }

    @Override
    public List<String> getExtents() {
        return extent = Lists.createWhenNull(extent);
    }

    @Override
    public void setExtents(List<String> extents) {
        this.extent = extents;
    }

    @Override
    public String getExtent() {
        return Lists.firstEntry(extent);
    }

    @Override
    public void setExtent(String extent) {
        this.extent = Lists.create(extent);
    }

    @Override
    public List<String> getHasFormats() {
        return null;
    }

    @Override
    public void setHasFormats(List<String> hasFormats) {
        this.hasFormat = hasFormats;
    }

    @Override
    public String getHasFormat() {
        return Lists.firstEntry(hasFormat);
    }

    @Override
    public void setHasFormat(String hasFormat) {
        this.hasFormat = Lists.create(hasFormat);
    }

    @Override
    public List<String> getHasParts() {
        return hasPart = Lists.createWhenNull(hasPart);
    }

    @Override
    public void setHasParts(List<String> hasParts) {
        this.hasPart = hasParts;
    }

    @Override
    public String getHasPart() {
        return Lists.firstEntry(hasPart);
    }

    @Override
    public void setHasPart(String hasPart) {
        this.hasPart = Lists.create(hasPart);
    }

    @Override
    public List<String> getHasVersions() {
        return hasVersion = Lists.createWhenNull(hasVersion);
    }

    @Override
    public void setHasVersions(List<String> hasVersions) {
        this.hasVersion = hasVersions;
    }

    @Override
    public String getHasVersion() {
        return Lists.firstEntry(hasVersion);
    }

    @Override
    public void setHasVersion(String hasVersion) {
        this.hasVersion = Lists.create(hasVersion);
    }

    @Override
    public List<String> getInstructionalMethods() {
        return instructionalMethod = Lists.createWhenNull(instructionalMethod);
    }

    @Override
    public void setInstructionalMethods(List<String> instructionalMethods) {
        this.instructionalMethod = instructionalMethods;
    }

    @Override
    public String getInstructionalMethod() {
        return Lists.firstEntry(instructionalMethod);
    }

    @Override
    public void setInstructionalMethod(String instructionalMethod) {
        this.instructionalMethod = Lists.create(instructionalMethod);
    }

    @Override
    public List<String> getIsFormatOfList() {
        return isFormatOf = Lists.createWhenNull(isFormatOf);
    }

    @Override
    public void setIsFormatOfList(List<String> isFormatOfList) {
        this.isFormatOf = isFormatOfList;
    }

    @Override
    public String getIsFormatOf() {
        return Lists.firstEntry(isFormatOf);
    }

    @Override
    public void setIsFormatOf(String isFormatOf) {
        this.isFormatOf = Lists.create(isFormatOf);
    }

    @Override
    public List<String> getIsPartOfList() {
        return isPartOf = Lists.createWhenNull(isPartOf);
    }

    @Override
    public void setIsPartOfList(List<String> isPartOfList) {
        this.isPartOf = isPartOfList;
    }

    @Override
    public String getIsPartOf() {
        return Lists.firstEntry(isPartOf);
    }

    @Override
    public void setIsPartOf(String isPartOf) {
        this.isPartOf = Lists.create(isPartOf);
    }

    @Override
    public List<String> getIsReferencedByList() {
        return isReferencedBy = Lists.createWhenNull(isReferencedBy);
    }

    @Override
    public void setIsReferencedByList(List<String> isReferencedByList) {
        this.isReferencedBy = isReferencedByList;
    }

    @Override
    public String getIsReferencedBy() {
        return Lists.firstEntry(isReferencedBy);
    }

    @Override
    public void setIsReferencedBy(String isReferencedBy) {
        this.isReferencedBy = Lists.create(isReferencedBy);
    }

    @Override
    public List<String> getIsReplacedByList() {
        return isReplacedBy = Lists.createWhenNull(isReplacedBy);
    }

    @Override
    public void setIsReplacedByList(List<String> isReplacedByList) {
        this.isReplacedBy = isReplacedByList;
    }

    @Override
    public String getIsReplacedBy() {
        return Lists.firstEntry(isReplacedBy);
    }

    @Override
    public void setIsReplacedBy(String isReplacedBy) {
        this.isReplacedBy = Lists.create(isReplacedBy);
    }

    @Override
    public List<String> getIsRequiredByList() {
        return isRequiredBy = Lists.createWhenNull(isRequiredBy);
    }

    @Override
    public void setIsRequiredByList(List<String> isRequiredByList) {
        this.isRequiredBy = isRequiredByList;
    }

    @Override
    public String getIsRequiredBy() {
        return Lists.firstEntry(isRequiredBy);
    }

    @Override
    public void setIsRequiredBy(String isRequiredBy) {
        this.isRequiredBy = Lists.create(isRequiredBy);
    }

    @Override
    public List<Date> getIssuedList() {
        return issued = Lists.createWhenNull(issued);
    }

    @Override
    public void setIssuedList(List<Date> issuedList) {
        this.issued = issuedList;
    }

    @Override
    public Date getIssued() {
        return Lists.firstEntry(issued);
    }

    @Override
    public void setIssued(Date issued) {
        this.issued = Lists.create(issued);
    }

    @Override
    public List<String> getIsVersionOfList() {
        return isVersionOf = Lists.createWhenNull(isVersionOf);
    }

    @Override
    public void setIsVersionOfList(List<String> isVersionOfList) {
        this.isVersionOf = isVersionOfList;
    }

    @Override
    public String getIsVersionOf() {
        return Lists.firstEntry(isVersionOf);
    }

    @Override
    public void setIsVersionOf(String isVersionOf) {
        this.isVersionOf = Lists.create(isVersionOf);
    }

    @Override
    public List<String> getLicenses() {
        return license = Lists.createWhenNull(license);
    }

    @Override
    public void setLicenses(List<String> licenses) {
        this.license = licenses;
    }

    @Override
    public String getLicense() {
        return Lists.firstEntry(license);
    }

    @Override
    public void setLicense(String license) {
        this.license = Lists.create(license);
    }

    @Override
    public List<String> getMediators() {
        return mediator = Lists.createWhenNull(mediator);
    }

    @Override
    public void setMediators(List<String> mediators) {
        this.mediator = mediators;
    }

    @Override
    public String getMediator() {
        return Lists.firstEntry(mediator);
    }

    @Override
    public void setMediator(String mediator) {
        this.mediator = Lists.create(mediator);
    }

    @Override
    public List<String> getMediums() {
        return medium = Lists.createWhenNull(medium);
    }

    @Override
    public void setMediums(List<String> mediums) {
        this.medium = mediums;
    }

    @Override
    public String getMedium() {
        return Lists.firstEntry(medium);
    }

    @Override
    public void setMedium(String medium) {
        this.medium = Lists.create(medium);
    }

    @Override
    public List<String> getModifiedList() {
        return modified = Lists.createWhenNull(modified);
    }

    @Override
    public void setModifiedList(List<String> modifiedList) {
        this.modified = modifiedList;
    }

    @Override
    public String getModified() {
        return Lists.firstEntry(modified);
    }

    @Override
    public void setModified(String modified) {
        this.modified = Lists.create(modified);
    }

    @Override
    public List<String> getProvenances() {
        return provenance = Lists.createWhenNull(provenance);
    }

    @Override
    public void setProvenances(List<String> provenances) {
        this.provenance = provenances;
    }

    @Override
    public String getProvenance() {
        return Lists.firstEntry(provenance);
    }

    @Override
    public void setProvenance(String provenance) {
        this.provenance = Lists.create(provenance);
    }

    @Override
    public List<String> getReferencesList() {
        return references = Lists.createWhenNull(references);
    }

    @Override
    public void setReferencesList(List<String> referencesList) {
        this.references = referencesList;
    }

    @Override
    public String getReferences() {
        return Lists.firstEntry(references);
    }

    @Override
    public void setReferences(String references) {
        this.references = Lists.create(references);
    }

    @Override
    public List<String> getReplacesList() {
        return replaces = Lists.createWhenNull(replaces);
    }

    @Override
    public void setReplacesList(List<String> replacesList) {
        this.replaces = replacesList;
    }

    @Override
    public String getReplaces() {
        return Lists.firstEntry(replaces);
    }

    @Override
    public void setReplaces(String replaces) {
        this.replaces = Lists.create(replaces);
    }

    @Override
    public List<String> getRequiresList() {
        return requires = Lists.createWhenNull(requires);
    }

    @Override
    public void setRequiresList(List<String> requiresList) {
        this.requires = requiresList;
    }

    @Override
    public String getRequires() {
        return Lists.firstEntry(requires);
    }

    @Override
    public void setRequires(String requires) {
        this.requires = Lists.create(requires);
    }

    @Override
    public List<String> getRightsHolderList() {
        return rightsHolder = Lists.createWhenNull(rightsHolder);
    }

    @Override
    public void setRightsHolderList(List<String> rightsHolderList) {
        this.rightsHolder = rightsHolderList;
    }

    @Override
    public String getRightsHolder() {
        return Lists.firstEntry(rightsHolder);
    }

    @Override
    public void setRightsHolder(String rightsHolder) {
        this.rightsHolder = Lists.create(rightsHolder);
    }

    @Override
    public List<String> getSpatialList() {
        return spatial = Lists.createWhenNull(spatial);
    }

    @Override
    public void setSpatialList(List<String> spatialList) {
        this.spatial = spatialList;
    }

    @Override
    public String getSpatial() {
        return Lists.firstEntry(spatial);
    }

    @Override
    public void setSpatial(String spatial) {
        this.spatial = Lists.create(spatial);
    }

    @Override
    public List<String> getTableOfContentsList() {
        return tableOfContents = Lists.createWhenNull(tableOfContents);
    }

    @Override
    public void setTableOfContentsList(List<String> tableOfContentsList) {
        this.tableOfContents = tableOfContentsList;
    }

    @Override
    public String getTableOfContents() {
        return Lists.firstEntry(tableOfContents);
    }

    @Override
    public void setTableOfContents(String tableOfContents) {
        this.tableOfContents = Lists.create(tableOfContents);
    }

    @Override
    public List<String> getTemporalList() {
        return temporal = Lists.createWhenNull(temporal);
    }

    @Override
    public void setTemporalList(List<String> temporalList) {
        this.temporal = temporalList;
    }

    @Override
    public String getTemporal() {
        return Lists.firstEntry(temporal);
    }

    @Override
    public void setTemporal(String temporal) {
        this.temporal = Lists.create(temporal);
    }

    @Override
    public List<String> getValidList() {
        return valid = Lists.createWhenNull(valid);
    }

    @Override
    public void setValidList(final List<String> validList) {
        this.valid = validList;
    }

    @Override
    public String getValid() {
        return Lists.firstEntry(valid);
    }

    @Override
    public void setValid(final String valid) {
        this.valid = Lists.create(valid);
    }

    @Override
    public Class<? extends CopyFrom> getInterface() {
        return DCTermsModule.class;
    }

    @Override
    public final void copyFrom(final CopyFrom obj) {
        COPY_FROM_HELPER.copy(this, obj);
    }

    private static final CopyFromHelper COPY_FROM_HELPER;

    static {
        final Map<String, Class<?>> basePropInterfaceMap = new HashMap<String, Class<?>>();
        basePropInterfaceMap.put("titles", String.class);
        basePropInterfaceMap.put("creators", String.class);
        basePropInterfaceMap.put("subjects", DCSubject.class);
        basePropInterfaceMap.put("descriptions", String.class);
        basePropInterfaceMap.put("publishers", String.class);
        basePropInterfaceMap.put("contributors", String.class);
        basePropInterfaceMap.put("dates", Date.class);
        basePropInterfaceMap.put("types", String.class);
        basePropInterfaceMap.put("formats", String.class);
        basePropInterfaceMap.put("identifiers", String.class);
        basePropInterfaceMap.put("sources", String.class);
        basePropInterfaceMap.put("languages", String.class);
        basePropInterfaceMap.put("relations", String.class);
        basePropInterfaceMap.put("coverages", String.class);
        basePropInterfaceMap.put("rightsList", String.class);

        basePropInterfaceMap.put("theAbstracts", String.class);
        basePropInterfaceMap.put("accessRightsList", String.class);
        basePropInterfaceMap.put("accrualMethods", String.class);
        basePropInterfaceMap.put("accrualPeriodicityList", String.class);
        basePropInterfaceMap.put("accrualPolicyList", String.class);
        basePropInterfaceMap.put("alternatives", String.class);
        basePropInterfaceMap.put("audiences", String.class);
        basePropInterfaceMap.put("availableList", String.class);
        basePropInterfaceMap.put("bibliographicCitations", String.class);
        basePropInterfaceMap.put("conformsTos", String.class);
        basePropInterfaceMap.put("contributors", String.class);
        basePropInterfaceMap.put("createdList", String.class);
        basePropInterfaceMap.put("dateAcceptedList", Date.class);
        basePropInterfaceMap.put("dateCopyrightedList", Date.class);
        basePropInterfaceMap.put("dateSubmittedList", Date.class);
        basePropInterfaceMap.put("educationLevels", String.class);
        basePropInterfaceMap.put("extents", String.class);
        basePropInterfaceMap.put("hasFormats", String.class);
        basePropInterfaceMap.put("hasParts", String.class);
        basePropInterfaceMap.put("hasVersions", String.class);
        basePropInterfaceMap.put("instructionalMethods", String.class);
        basePropInterfaceMap.put("isFormatOfList", String.class);
        basePropInterfaceMap.put("isPartOfList", String.class);
        basePropInterfaceMap.put("isReferencedByList", String.class);
        basePropInterfaceMap.put("isReplacedByList", String.class);
        basePropInterfaceMap.put("isRequiredByList", String.class);
        basePropInterfaceMap.put("issuedList", Date.class);
        basePropInterfaceMap.put("isVersionOfList", String.class);
        basePropInterfaceMap.put("licenses", String.class);
        basePropInterfaceMap.put("mediators", String.class);
        basePropInterfaceMap.put("mediums", String.class);
        basePropInterfaceMap.put("modifiedList", String.class);
        basePropInterfaceMap.put("provenances", String.class);
        basePropInterfaceMap.put("referencesList", String.class);
        basePropInterfaceMap.put("replacesList", String.class);
        basePropInterfaceMap.put("requiresList", String.class);
        basePropInterfaceMap.put("rightsHolders", String.class);
        basePropInterfaceMap.put("spatialList", String.class);
        basePropInterfaceMap.put("tableOfContentsList", String.class);
        basePropInterfaceMap.put("temporalList", String.class);
        basePropInterfaceMap.put("validList", String.class);

        final Map<Class<? extends CopyFrom>, Class<?>> basePropClassImplMap = new HashMap<Class<? extends CopyFrom>, Class<?>>();
        basePropClassImplMap.put(DCSubject.class, DCSubjectImpl.class);

        COPY_FROM_HELPER = new CopyFromHelper(DCModule.class, basePropInterfaceMap, basePropClassImplMap);
    }
}
