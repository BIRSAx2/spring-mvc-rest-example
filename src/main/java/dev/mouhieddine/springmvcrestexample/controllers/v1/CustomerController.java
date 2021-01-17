package dev.mouhieddine.springmvcrestexample.controllers.v1;

import dev.mouhieddine.springmvcrestexample.api.v1.model.CustomerDTO;
import dev.mouhieddine.springmvcrestexample.api.v1.model.CustomerListDTO;
import dev.mouhieddine.springmvcrestexample.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Mouhieddine.dev
 * @since : 1/16/2021, Saturday
 **/

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

  public static final String BASE_URL = "/api/v1/customers";

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping({"", "/"})
  @ResponseStatus(HttpStatus.OK)
  public CustomerListDTO getAllCustomers() {
    return new CustomerListDTO(customerService.getAllCustomers());
  }

  @GetMapping({"/{id}", "/{id}/"})
  @ResponseStatus(HttpStatus.OK)
  public CustomerDTO getCustomerById(@PathVariable Long id) {
    return customerService.getCustomerById(id);
  }

  @PutMapping({"/{id}", "/{id}/"})
  @ResponseStatus(HttpStatus.OK)
  public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
    return customerService.saveCustomerByDTO(id, customerDTO);
  }

  @PatchMapping({"/{id}", "/{id}/"})
  @ResponseStatus(HttpStatus.OK)
  public CustomerDTO patchCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
    return customerService.patchCustomer(id, customerDTO);
  }

  @DeleteMapping({"/{id}", "/{id}/"})
  @ResponseStatus(HttpStatus.OK)
  public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomerById(id);
  }

  @PostMapping({"", "/"})
  @ResponseStatus(HttpStatus.CREATED)
  public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
    return customerService.createNewCustomer(customerDTO);
  }
}
