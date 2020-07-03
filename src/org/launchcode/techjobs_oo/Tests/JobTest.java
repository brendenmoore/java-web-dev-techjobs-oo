package org.launchcode.techjobs_oo.Tests;

import org.junit.Assert;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        Assert.assertEquals(job2.getId() -1, job1.getId(), .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertNotNull(testJob.getPositionType());
        Assert.assertNotNull(testJob.getEmployer());
        Assert.assertNotNull(testJob.getLocation());
        Assert.assertNotNull(testJob.getName());
        Assert.assertNotNull(testJob.getCoreCompetency());
        Assert.assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
        Assert.assertEquals(testJob.getLocation().getValue(), "Desert");
        Assert.assertEquals(testJob.getEmployer().getValue(), "ACME");
        Assert.assertEquals(testJob.getPositionType().getValue(), "Quality control");
        Assert.assertEquals(testJob.getName(), "Product tester");
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertNotEquals(testJob1, testJob2);
    }

    @Test
    public void jobStringShouldReturnBlankLineBeforeAndAfter() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = testJob.toString();
        Assert.assertEquals(testString.charAt(0), '\n');
        Assert.assertEquals(testString.charAt(testString.length() - 1), '\n');
    }

    @Test
    public void testCustomStringForJobs() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertEquals(testJob.toString(), "\nID: 1\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");
    }

    @Test
    public void testJobToStringReturnsDataNotAvailable() {
        Job testJob = new Job("Product tester", new Employer(), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertEquals(testJob.toString(), "\nID: 1\nName: Product tester\nEmployer: Data not available\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");
    }

    @Test
    public void emptyJobReturnsMessage() {
        Job testJob = new Job();
        Assert.assertEquals("OOPS! This job does not seem to exist.", testJob.toString());
    }
}
