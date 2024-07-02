1. Jsoup

- String blogUrl = "https://spring.io/blog";
  Document doc = Jsoup.connect(blogUrl).get();
- Jsoup get text content:
  - String textWithLines = Jsoup.parse(doc.html()).wholeText();
    System.out.println(textWithLines);
  - Jsoup.parse(doc).text();

  
2. Coding connvetions used:
   - Kernighan & Ritchie indentation
   - max 120 chars line length
   - camelCase for Variable names
     - variable names are intutive and descriptive
   - PascalCase for Classnames
   - Inverted if where possible
   - no vertical alignment
   - order in classes:
     - Constants (if any)
     - Static variables (if any)
     - Instance variables (if any)
     - Constructors
     - Methods
   - For getters and setters mostly used copilot completion


one implementation method vs 3 implementation method
- one implementation simpler/ more organised
- 3 implementation not exactly the strategy pattern

- strategy pattern: not using a direct context class is also fine
- 