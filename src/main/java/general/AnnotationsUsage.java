package general;

public class AnnotationsUsage extends Report {

    /*@Override confirms the override mechanism*/
    @Override
    /*@Deprecated indicates obsolete methods*/
    @Deprecated
    public String generate(String name, String body) {
        return "<h1>" + name + "</h1>"
                + "<br/>" + "<span>" + body + "</span>";
    }
    /*SuppressWarnings indicates we want to ignore certain warnings from a part of the code*/
    @SuppressWarnings({}) // parameters??
    public void testWarningSuppress() {
        System.out.println("test");
    }

}
