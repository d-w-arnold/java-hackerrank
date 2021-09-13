package ProblemSolving.Implementation.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 08/07/2021
 */
class EncryptionTest
{

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void encryption_1()
    {
        assertEquals("imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau", Encryption.encryption("ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots"));
    }

    @Test
    void encryption_2()
    {
        assertEquals("hae and via ecy", Encryption.encryption("haveaniceday"));
    }

    @Test
    void encryption_3()
    {
        assertEquals("fto ehg ee dd", Encryption.encryption("feedthedog"));
    }

    @Test
    void encryption_4()
    {
        assertEquals("clu hlt io", Encryption.encryption("chillout"));
    }
}