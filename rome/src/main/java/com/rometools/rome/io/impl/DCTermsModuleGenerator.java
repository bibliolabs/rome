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

package com.rometools.rome.io.impl;

import com.rometools.rome.feed.module.DCSubject;
import com.rometools.rome.feed.module.DCTermsModule;
import com.rometools.rome.feed.module.Module;
import com.rometools.rome.io.ModuleGenerator;

import com.rometools.utils.Lists;
import org.jdom2.Attribute;
import org.jdom2.Element;
import org.jdom2.Namespace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class DCTermsModuleGenerator implements ModuleGenerator {
    private static final String TAXO_URI = "http://purl.org/rss/1.0/modules/taxonomy/";
    private static final String RDF_URI = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";

    private static final Namespace DC_NS = Namespace.getNamespace("dcterms", DCTermsModule.URI);
    private static final Namespace TAXO_NS = Namespace.getNamespace("taxo", TAXO_URI);
    private static final Namespace RDF_NS = Namespace.getNamespace("rdf", RDF_URI);

    private static final Set<Namespace> NAMESPACES;

    static {
        final Set<Namespace> nss = new HashSet<Namespace>();
        nss.add(DC_NS);
        nss.add(TAXO_NS);
        nss.add(RDF_NS);
        NAMESPACES = Collections.unmodifiableSet(nss);
    }

    private Namespace getDCNamespace() {
        return DC_NS;
    }

    private Namespace getRDFNamespace() {
        return RDF_NS;
    }

    private Namespace getTaxonomyNamespace() {
        return TAXO_NS;
    }

    @Override
    public String getNamespaceUri() {
        return DCTermsModule.URI;
    }

    /**
     * Returns a set with all the URIs (JDOM Namespace elements) this module generator uses.
     * <p/>
     * It is used by the the feed generators to add their namespace definition in the root element
     * of the generated document (forward-missing of Java 5.0 Generics).
     * <p/>
     *
     * @return a set with all the URIs this module generator uses.
     */
    @Override
    public final Set<Namespace> getNamespaces() {
        return NAMESPACES;
    }

    /**
     * Populate an element tree with elements for a module.
     * <p>
     *
     * @param module the module to populate from.
     * @param element the root element to attach child elements to.
     */
    @Override
    public final void generate(final Module module, final Element element) {
        final DCTermsModule dcModule = (DCTermsModule) module;

        addStringIfNotEmpty(element, "title", dcModule.getTitles());
        addStringIfNotEmpty(element, "creator", dcModule.getCreators());

        final List<DCSubject> subjects = dcModule.getSubjects();
        for (final DCSubject dcSubject : subjects) {
            element.addContent(generateSubjectElement(dcSubject));
        }

        addStringIfNotEmpty(element, "description", dcModule.getDescriptions());
        addDateIfNotEmpty(element, "date", dcModule.getDates());
        addStringIfNotEmpty(element, "publisher", dcModule.getPublishers());
        addStringIfNotEmpty(element, "contributor", dcModule.getContributors());
        addStringIfNotEmpty(element, "type", dcModule.getTypes());
        addStringIfNotEmpty(element, "format", dcModule.getFormats());
        addStringIfNotEmpty(element, "identifier", dcModule.getIdentifiers());
        addStringIfNotEmpty(element, "source", dcModule.getSources());
        addStringIfNotEmpty(element, "language", dcModule.getLanguages());
        addStringIfNotEmpty(element, "relation", dcModule.getRelations());
        addStringIfNotEmpty(element, "coverage", dcModule.getCoverages());
        addStringIfNotEmpty(element, "rights", dcModule.getRightsList());

        addStringIfNotEmpty(element, "abstract", dcModule.getAbstractList());
        addStringIfNotEmpty(element, "accessRights", dcModule.getAccessRightsList());
        addStringIfNotEmpty(element, "accrualMethod", dcModule.getAccrualMethods());
        addStringIfNotEmpty(element, "accrualPeriodicity", dcModule.getAccrualPeriodicityList());
        addStringIfNotEmpty(element, "accrualPolicy", dcModule.getAccrualPolicyList());
        addStringIfNotEmpty(element, "alternative", dcModule.getAlternatives());
        addStringIfNotEmpty(element, "audience", dcModule.getAudiences());
        addStringIfNotEmpty(element, "available", dcModule.getAvailableList());
        addStringIfNotEmpty(element, "bibliographicCitation", dcModule.getBibliographicCitations());
        addStringIfNotEmpty(element, "conformsTo", dcModule.getConformsToList());
        addDateIfNotEmpty(element, "created", dcModule.getCreatedList());
        addDateIfNotEmpty(element, "dateAccepted", dcModule.getDateAcceptedList());
        addDateIfNotEmpty(element, "dateCopyrighted", dcModule.getDateCopyrightedList());
        addDateIfNotEmpty(element, "dateSubmitted", dcModule.getDateSubmittedList());
        addStringIfNotEmpty(element, "educationLevel", dcModule.getEducationLevels());
        addStringIfNotEmpty(element, "extent", dcModule.getExtents());
        addStringIfNotEmpty(element, "hasFormat", dcModule.getHasFormats());
        addStringIfNotEmpty(element, "hasPart", dcModule.getHasParts());
        addStringIfNotEmpty(element, "hasVersion", dcModule.getHasVersions());
        addStringIfNotEmpty(element, "instructionalMethod", dcModule.getInstructionalMethods());
        addStringIfNotEmpty(element, "isFormatOf", dcModule.getIsFormatOfList());
        addStringIfNotEmpty(element, "isPartOf", dcModule.getIsPartOfList());
        addStringIfNotEmpty(element, "isReferencedBy", dcModule.getIsReferencedByList());
        addStringIfNotEmpty(element, "isReplacedBy", dcModule.getIsReplacedByList());
        addStringIfNotEmpty(element, "isRequiredBy", dcModule.getIsRequiredByList());
        addDateIfNotEmpty(element, "issued", dcModule.getIssuedList());
        addStringIfNotEmpty(element, "isVersionOf", dcModule.getIsVersionOfList());
        addStringIfNotEmpty(element, "license", dcModule.getLicenses());
        addStringIfNotEmpty(element, "mediator", dcModule.getMediators());
        addStringIfNotEmpty(element, "medium", dcModule.getMediums());
        addStringIfNotEmpty(element, "modified", dcModule.getModifiedList());
        addStringIfNotEmpty(element, "provenance", dcModule.getProvenances());
        addStringIfNotEmpty(element, "references", dcModule.getReferencesList());
        addStringIfNotEmpty(element, "replaces", dcModule.getReplacesList());
        addStringIfNotEmpty(element, "requires", dcModule.getRequiresList());
        addStringIfNotEmpty(element, "rightsHolder", dcModule.getRightsHolderList());
        addStringIfNotEmpty(element, "spatial", dcModule.getSpatialList());
        addStringIfNotEmpty(element, "tableOfContents", dcModule.getTableOfContentsList());
        addStringIfNotEmpty(element, "temporal", dcModule.getTemporalList());
        addStringIfNotEmpty(element, "valid", dcModule.getValidList());
    }

    /**
     * Utility method to generate an element for a subject.
     * <p>
     *
     * @param subject the subject to generate an element for.
     * @return the element for the subject.
     */
    protected Element generateSubjectElement(final DCSubject subject) {

        final Element subjectElement = new Element("subject", getDCNamespace());

        final String taxonomyUri = subject.getTaxonomyUri();
        final String value = subject.getValue();

        if (taxonomyUri != null) {

            final Attribute resourceAttribute = new Attribute("resource", taxonomyUri, getRDFNamespace());

            final Element topicElement = new Element("topic", getTaxonomyNamespace());
            topicElement.setAttribute(resourceAttribute);

            final Element descriptionElement = new Element("Description", getRDFNamespace());
            descriptionElement.addContent(topicElement);

            if (value != null) {
                final Element valueElement = new Element("value", getRDFNamespace());
                valueElement.addContent(value);
                descriptionElement.addContent(valueElement);
            }

            subjectElement.addContent(descriptionElement);

        } else {
            subjectElement.addContent(value);
        }

        return subjectElement;
    }

    protected void addStringIfNotEmpty(final Element element, final String elementName, final List<String> theList) {
        if (Lists.isNotEmpty(theList)) {
            element.addContent(generateSimpleElementList(elementName, theList));
        }
    }

    protected void addDateIfNotEmpty(final Element element, final String elementName, final List<Date> theList) {
        if (Lists.isNotEmpty(theList)) {
            for (final Date date : theList) {
                element.addContent(generateSimpleElement(elementName, DateParser.formatW3CDateTime(date, Locale.US)));
            }
        }
    }
    /**
     * Utility method to generate a single element containing a string.
     * <p>
     *
     * @param name the name of the elment to generate.
     * @param value the value of the text in the element.
     * @return the element generated.
     */
    protected Element generateSimpleElement(final String name, final String value) {
        final Element element = new Element(name, getDCNamespace());
        element.addContent(value);
        return element;
    }

    /**
     * Utility method to generate a list of simple elements.
     * <p>
     *
     * @param name the name of the element list to generate.
     * @param values the list of values for the elements.
     * @return a list of Elements created.
     */
    protected List<Element> generateSimpleElementList(final String name, final List<String> values) {
        final List<Element> elements = new ArrayList<Element>();
        for (final String value : values) {
            elements.add(generateSimpleElement(name, value));
        }
        return elements;
    }
}
