package org.asciidoctor.maven.test.processors;

import java.util.Map;

import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.Preprocessor;
import org.asciidoctor.extension.PreprocessorReader;
import org.asciidoctor.extension.Reader;

public class ChangeAttributeValuePreprocessor extends Preprocessor {

    public static final String AUTHOR_NAME = "ThisIsMe";

    public ChangeAttributeValuePreprocessor(Map<String, Object> config) {
        super(config);
        System.out.println(String.format("%s(%s) initialized", this.getClass().getSimpleName(), this.getClass().getSuperclass().getSimpleName()));
    }

    @Override
    public Reader process(Document document, PreprocessorReader reader) {
        System.out.println("Processing " + this.getClass().getSimpleName());
        System.out.println("Processing: blocks found: " + document.getBlocks().size());
        document.getAttributes().put("author", AUTHOR_NAME);
        return reader;
    }
}
