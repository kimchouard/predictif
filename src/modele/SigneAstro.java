/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Kim
 */
@Entity
public class SigneAstro implements Serializable {
    @Id
    private int iMois;
    private String sAstro;

    public SigneAstro() {
    }

    public SigneAstro(String sAstro, int iMois) {
        this.sAstro = sAstro;
        this.iMois = iMois;
    }

    public String getsAstro() {
        return sAstro;
    }
}
