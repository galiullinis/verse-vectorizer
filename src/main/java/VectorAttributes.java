public enum VectorAttributes {
    LINE_LENGTH("line_length"),
    PUNCT_TO_WORDS("punctuations_to_words"),
    TEXT_VOLUME("text_volume"),
    RHYME("rhyme");


    private String code;

    VectorAttributes(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
