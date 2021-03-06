package org.opens.kbaccess.entity.dao.subject;

import java.util.Collection;
import java.util.List;
import org.opens.kbaccess.entity.authorization.Account;
import org.opens.kbaccess.entity.reference.ReferenceTest;
import org.opens.kbaccess.entity.reference.Result;
import org.opens.kbaccess.entity.subject.Testcase;
import org.opens.tanaguru.sdk.entity.dao.GenericDAO;

/**
 *
 * @author jkowalczyk
 * @version 1.0.0
 */
public interface TestcaseDAO extends GenericDAO<Testcase, Long> {
    
    /**
     * @return the max value of Priority field
     */
    int findMaxPriorityValueFromTable();

    /**
     * @param account
     * @return all the testcases created by a user or null if there are none
     */
    List<Testcase> findAllFromAccount(Account account);

    /**
     *
     * @param nbOfTestcases The maximum number of testcases to return.
     * @return the last created testcases or null if there are none
     */
    List<Testcase> findLastTestcases(int nbOfTestcases);

    /**
     *
     * @param account The account in which to search the testcases.
     * @param nbOfTestcases The maximum number of testcases to return.
     * @return the last created testcases, associated with the account
     *         or null if the user does not have any testcases yet.
     */
    List<Testcase> findLastTestcasesFromAccount(
            Account account,
            int nbOfTestcases);

    /**
     * Get the test cases matching the given criteria.
     * 
     * All criteria are restrictive unless they are null. This means, the
     * returned list will contain all the test cases that match all the
     * non-null criteria and we do not care about the null criteria.
     * 
     * @param referenceTestSet
     * @param result
     * @return The test cases matching the given criteria
     */
    List<Testcase> findAllFromUserSelection(
            Collection<ReferenceTest> referenceTestCollection,
            Result result);
    
    /**
     * 
     * @return The number of Testcase in database
     */
    Long count();
}
