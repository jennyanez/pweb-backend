package cu.edu.cujae.pwebbackend.persistence.utils;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LoanPK implements Serializable {

    private Long loanId;
    private Long clientId;
    private Long copyId;


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.loanId);
        hash = 59 * hash + Objects.hashCode(this.clientId);
        hash = 59 * hash + Objects.hashCode(this.copyId);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoanPK other = (LoanPK) obj;
        if (!Objects.equals(this.clientId, other.clientId)) {
            return false;
        }
        if (!Objects.equals(this.copyId, other.copyId)) {
            return false;
        }
        if (!Objects.equals(this.loanId, other.loanId)) {
            return false;
        }
        return true;
    }

    /***********************        Getters  And  Setters         ************************/

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCopyId() {
        return copyId;
    }

    public void setCopyId(Long copyId) {
        this.copyId = copyId;
    }
}
