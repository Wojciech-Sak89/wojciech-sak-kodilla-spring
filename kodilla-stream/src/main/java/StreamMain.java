public class StreamMain {
    public static void main(String[] args) {
//        SaySomething saySomething = new SaySomething();
//        saySomething.say();

//        Processor processor = new Processor();
//        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
//        processor.execute(executeSaySomething);

//        Processor processor = new Processor();
//        Executor codeToExecute = () -> System.out.println("This is an example text.");
//        processor.execute(codeToExecute);

//        Processor processor = new Processor();
//        processor.execute(() -> System.out.println("This is an example text."));

//        System.out.println("Calculating expressions with lambdas");
//        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
//
//        System.out.println("Calculating expressions with method references");
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

//        PoemBeautifier poemBeautifier = new PoemBeautifier();
//        poemBeautifier.beautify("pretty text", (a) -> a.toUpperCase());
//        poemBeautifier.beautify("alfabetINeed!!!", (a) -> "ABC " + a + " ABC");
//        poemBeautifier.beautify("CAPS TEXT", (a) -> a.toLowerCase());
//        poemBeautifier.beautify("I DON'T NEED ANY \"A\" LETTERS!!! I NEED \"B\" INSTEAD", (a) -> a.replaceAll("A", "B"));

//        System.out.println("Using Stream to generate even numbers from 1 to 20");
//        NumbersGenerator.generateEven(20);

       /* People.getList().stream()
                .map(String::toUpperCase) // = .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s)); // = .forEach(System.out::println);*/

//        People.getList().stream()
//                .filter(s -> s.length() > 11)
//                .forEach(System.out::println);

//        People.getList().stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.length() > 11)
//                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
//                .filter(s -> s.substring(0, 1).equals("M"))
//                .forEach(System.out::println);

//        BookDirectory theBookDirectory = new BookDirectory();
//        theBookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .forEach(System.out::println);

//        BookDirectory theBookDirectory = new BookDirectory();
//        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .collect(Collectors.toList());
//
//        System.out.println("# elements: " + theResultListOfBooks.size());
//        theResultListOfBooks.stream()
//                .forEach(System.out::println);






        //***
//        BookDirectory theBookDirectory = new BookDirectory();
//
//        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .collect(Collectors.toMap(Book::getSignature, book -> book));
//
//        System.out.println("# elements: " + theResultMapOfBooks.size());
//        theResultMapOfBooks.entrySet().stream()
//                .map(entry -> entry.getKey() + ": " + entry.getValue())
//                .forEach(System.out::println);
        //***

        //        BookDirectory theBookDirectory = new BookDirectory();
//        String theResultStringOfBooks = theBookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .map(Book::toString)
//                .collect(Collectors.joining(",\n","<<",">>"));
//
//        System.out.println(theResultStringOfBooks);


//        Forum theForum = new Forum();
//        LocalDate now = LocalDate.now();
//        LocalDate twentyYearsAgo = now.minusYears(20);
//
//        Map<Integer, ForumUser> theResultMapOfForumUsers = theForum.getUserList().stream()
//                .filter(forumUser -> forumUser.getSex() == 'M')
//                .filter(forumUser -> (forumUser.getBirthYear().isBefore(twentyYearsAgo)) || (forumUser.getBirthYear().isEqual(twentyYearsAgo)))
//                .filter(forumUser -> forumUser.getPostsPublished() > 0)
//                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));
//
//        theResultMapOfForumUsers.entrySet().stream()
//                .map(entry -> entry.getKey() + ": " + entry.getValue())
//                .forEach(System.out::println);


    }
}
