package example.domain.model.specification;

/**
 * 片道/往復
 */
public enum TicketType {
    片道,
    往復
    ;

    public boolean is片道() {
        return this == 片道;
    }
}