package tec.utpl.store.serviceshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tec.utpl.store.serviceshopping.entity.InvoiceItem;

@Repository
public interface InvoiceItemsRepository  extends JpaRepository<InvoiceItem,Long> {
}
