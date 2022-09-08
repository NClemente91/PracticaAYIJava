package com.claseDiezJPA.app;

import com.claseDiezJPA.app.configuration.JpaUtilDB;
import com.claseDiezJPA.app.entity.Cliente;
import com.claseDiezJPA.app.services.IClienteService;
import com.claseDiezJPA.app.services.impl.ClienteServiceImpl;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class JpaCrud {

    public static void main(String[] args) {

        EntityManager em = JpaUtilDB.getEntityManager();

        IClienteService service = new ClienteServiceImpl(em);

//        System.out.println("========== listar ==========");
//        List<Cliente> clientes = service.getAll();
//        clientes.forEach(System.out::println);

//        System.out.println("========== obtener por id ==========");
//        Optional<Cliente> optionalCliente = service.getById(1L);
//        optionalCliente.ifPresent(System.out::println);

//        System.out.println("========== insertar nuevo cliente ===========");
//        Cliente cliente = new Cliente();
//        cliente.setId(9L);
//        cliente.setNombre("GermanMod");
//        cliente.setApellido("PeraltaMod");
//        cliente.setFormaPago("paypalMod");
//        cliente.setFechaCreacion(LocalDate.now());
//
//        service.insert(cliente);
//        System.out.println("cliente guardado con exito");
//        service.getAll().forEach(System.out::println);

//        System.out.println("=========== editar cliente ==========");
//        Cliente cliente = new Cliente();
//        cliente.setId(9L);
//        Long id = cliente.getId();
//        Optional<Cliente> optionalCliente = service.getById(id);
//        optionalCliente.ifPresent(c -> {
//            c.setFormaPago("mercado pago");
//            service.guardar(c);
//            System.out.println("cliente editado con exito!");
//            service.getAll().forEach(System.out::println);
//        });

//        System.out.println("========== eliminar cliente ===========");
//        service.eliminar(9L);


        em.close();

    }

}
