import Course.Course;
import org.junit.Assert;
import org.junit.Test;

public class TestClass {

    @Test
    public void testPoint() {
        Course lear = new Course();
        Assert.assertTrue(lear.testPoints(new String[]{"1", "3", "4", "5", "6"}));
        Assert.assertFalse(lear.testPoints(new String[]{"4", "3", "4", "a", "6"}));
        Assert.assertFalse(lear.testPoints(new String[]{"4", "3", "a", "3", "6"}));
        Assert.assertFalse(lear.testPoints(new String[]{"4", "a", "2", "3", "6"}));
        Assert.assertTrue(lear.testPoints(new String[]{"a", "1", "2", "3", "6"}));
        Assert.assertFalse(lear.testPoints(new String[]{"0", "1", "2", "3", "a"}));
    }

    @Test
    public void testLastNameCorrect() {
        Course learn = new Course();
        Assert.assertFalse(learn.testLastName("O?uz"));
        Assert.assertTrue(learn.testLastName("Krechin"));
        Assert.assertTrue(learn.testLastName("van Helsing"));
        Assert.assertFalse(learn.testLastName("s"));
    }

    @Test
    public void testFirstNameCorrect() {
        Course learn = new Course();
        Assert.assertTrue(learn.testFirstName("Jean-Claude"));
        Assert.assertTrue(learn.testFirstName("O'Neill"));
        Assert.assertFalse(learn.testFirstName("J."));
        Assert.assertFalse(learn.testFirstName("? ? ?"));
    }

    @Test
    public void testEmailCorrect() {
        Course learn = new Course();
        Assert.assertTrue(learn.testEmail("dkrec@list.ru"));
        Assert.assertTrue(learn.testEmail("ewq321d@mail.ru"));
        Assert.assertTrue(learn.testEmail("32131@gmail.cum"));
        Assert.assertFalse(learn.testEmail("33231"));
        Assert.assertFalse(learn.testEmail("33231qs@12"));
        Assert.assertFalse(learn.testEmail("email@e@mail.xyz"));
    }
}

