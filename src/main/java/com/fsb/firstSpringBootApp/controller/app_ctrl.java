 package com.fsb.firstSpringBootApp.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fsb.firstSpringBootApp.models.Categorie_pro;
import com.fsb.firstSpringBootApp.models.Clame;
import com.fsb.firstSpringBootApp.models.Produit;
import com.fsb.firstSpringBootApp.models.Profil;
import com.fsb.firstSpringBootApp.models.Stat;
import com.fsb.firstSpringBootApp.models.Type_pro;
import com.fsb.firstSpringBootApp.models.User;
import com.fsb.firstSpringBootApp.models.Vente;
import com.fsb.firstSpringBootApp.rep.Clame_rep;
import com.fsb.firstSpringBootApp.rep.Produit_rep;
import com.fsb.firstSpringBootApp.rep.Profil_rep;
import com.fsb.firstSpringBootApp.rep.State_rep;
import com.fsb.firstSpringBootApp.rep.User_rep;
import com.fsb.firstSpringBootApp.rep.Vente_rep;
import com.fsb.firstSpringBootApp.rep.categoriepro_rep;
import com.fsb.firstSpringBootApp.rep.typepro_rep;

 
@CrossOrigin(origins = "http://localhost:4200") // Replace with your Angular app's URL
@RestController
@RequestMapping("/api/v0")
public class app_ctrl {


	@Autowired
	User_rep User_rep;
	@Autowired
	categoriepro_rep categorie_rep;
	@Autowired
	typepro_rep typepro_rep;
	@Autowired
	Vente_rep Vente_rep;
	@Autowired
	State_rep State_rep;
	@Autowired
	Profil_rep Profil_rep;
	@Autowired
	Clame_rep Clame_rep;
	@Autowired
	Produit_rep Produit_rep;
	 @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	
	  
   
   

    //User
    @PostMapping("/enregistreruser")
    public ResponseEntity<?> enregistreruser(@Validated @RequestBody User User) {
        if (User.getMdp().equals(User.getConfirm_mdp())) {
            return new ResponseEntity<>("Passwords do not match", HttpStatus.BAD_REQUEST);
        }

        // Hash the password before saving
        User.setMdp(bCryptPasswordEncoder.encode(User.getMdp()));
        User.setConfirm_mdp(bCryptPasswordEncoder.encode(User.getMdp()));
  
	     List<String> l = new ArrayList<>();
        l.add("USER");
        User.setRoles(l);
        User savedAdmin = User_rep.save(User);
        return new ResponseEntity<>(savedAdmin, HttpStatus.OK);
    }
	@GetMapping("/listUserBYID/{id}")
	public ResponseEntity<Object> listUserBYID(@PathVariable(value = "id") long id) {
		User admin = User_rep.findById(id).get();
		 if(admin!=null)
		return new ResponseEntity<>(admin, HttpStatus.OK); 
		 else
			 return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND); 
			 
	}
	 
	@DeleteMapping("/deletUserBYID/{id}")
	public ResponseEntity<Object> deletUserBYID(@PathVariable(value = "id") long id) {
		User admin = User_rep.findById(id).get();
		 if(admin!=null) {
			 User_rep.delete(admin);return new ResponseEntity<>(admin, HttpStatus.OK);
		 }
		
		 else
			 return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND); 
			 
	}
	@GetMapping("/listUser")
	public ResponseEntity<Object> listUser() {
		List<User> admins = User_rep.findAll();
		 if(admins!=null)
		return new ResponseEntity<>(admins, HttpStatus.OK); 
		 else
			 return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND); 
			 
	}
	
	   @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestParam(value = "name") String name, @RequestParam(value = "mdp") String mdp) {
	        List<User> admins = User_rep.findByname(name);

	        for (User a : admins) {
	            if (bCryptPasswordEncoder.matches(mdp, a.getMdp())) {
	                return new ResponseEntity<>(a, HttpStatus.OK);
	            }
	        }

	        return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
	    }

	
	
	
	
	
	
	
	
	
	
	
	
	   //vente
	@PostMapping("/enregistrervente")
	public ResponseEntity<?> enregistrervente(@Validated @RequestBody Vente vente) {
	    Optional<Produit> proOptional = Produit_rep.findById(vente.getId_pro());

	    if (proOptional.isPresent()) {
	        Produit pro = proOptional.get();
	        if (vente.getQte() <= pro.getQte()) {
	            Vente savedV = Vente_rep.save(vente);
	            savedV.ajoutNbV();
	            pro.supQte(vente.getQte());
	            return new ResponseEntity<>(savedV, HttpStatus.OK);
	        } else {
	        	Stat s=new Stat();
	        	s.setVente_echoue();
	            return new ResponseEntity<>("Quantity is insufficient", HttpStatus.BAD_REQUEST);
	        }
	    } else {
	        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	    }
	}

	
	
	@GetMapping("/nbVente")
	public ResponseEntity<Object> nbVente() {
		 Vente v=new Vente();
			 return new ResponseEntity<>(v.getNbV(), HttpStatus.NOT_FOUND); 
			 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//pro
	
	  @PostMapping("/enregistrerpro")
	  public ResponseEntity<?> enregistrerpro(@Validated @RequestBody Produit p) {
	      try {
	          // You can add validation logic here if needed before saving the product
	          // For example, check if the product fields are valid

	          Produit savedP = Produit_rep.save(p);
	          return new ResponseEntity<>(savedP, HttpStatus.OK);
	      } catch (Exception e) {
	          // Handle any exceptions that may occur during the save operation
	          return new ResponseEntity<>("Failed to save the product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	  }

	
	  @GetMapping("/Qte_pro")
	  public ResponseEntity<Object> Qte_pro(@RequestParam(value = "num") String num) {
	      List<Produit> produits = Produit_rep.findBynumpro(num);

	      if (!produits.isEmpty()) {
	          return new ResponseEntity<>(produits, HttpStatus.OK);
	      } else {
	          return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
	      }
	  }

	
	
	
	
	
	
	
	
	
	//categorie
	  
	  @PostMapping("/enregistrercategorie")
	  public ResponseEntity<?> enregistrercategorie(@Validated @RequestBody Categorie_pro p) {
	      try {
	    	  Categorie_pro savedP = categorie_rep.save(p);
	          return new ResponseEntity<>(savedP, HttpStatus.OK);
	      } catch (Exception e) {
	          // Handle any exceptions that may occur during the save operation
	          return new ResponseEntity<>("Failed to save the product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	  }
	  @GetMapping("/listcategorie")
		public ResponseEntity<Object> listcategorie() {
			List<Categorie_pro> admins = categorie_rep.findAll();
			 if(admins!=null)
			return new ResponseEntity<>(admins, HttpStatus.OK); 
			 else
				 return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND); 
				 
		}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  //type_pro
	  @PostMapping("/enregistrertype_pro")
	  public ResponseEntity<?> enregistrertype_pro(@Validated @RequestBody Type_pro p) {
	      try {
	          // You can add validation logic here if needed before saving the product
	          // For example, check if the product fields are valid

	    	  Type_pro savedP = typepro_rep.save(p);
	          return new ResponseEntity<>(savedP, HttpStatus.OK);
	      } catch (Exception e) {
	          // Handle any exceptions that may occur during the save operation
	          return new ResponseEntity<>("Failed to save the product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	  }
	  
	  
	  
	  @GetMapping("/listtypepro")
			public ResponseEntity<Object> listtypepro() {
				List<Type_pro> admins = typepro_rep.findAll();
				 if(admins!=null)
				return new ResponseEntity<>(admins, HttpStatus.OK); 
				 else
					 return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND); 
					 
			}
		  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  //stat
	
	 
	  @GetMapping("/nbuser")
	    public ResponseEntity<Object> getNumberOfUsers() {
	        List<User> users = User_rep.findAll();
	        int n = users.size();

	        

	        if (n > 0) {
	            return new ResponseEntity<>(n, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("No users with the specified roles found", HttpStatus.NOT_FOUND);
	        }
	    }
	 
	  @GetMapping("/nbvente")
	  public ResponseEntity<Object> nbvente() {
	      try {
	          int n = Vente_rep.countSales();

	           
	              return new ResponseEntity<>(n, HttpStatus.OK);
	       
	      } catch (DataIntegrityViolationException e) {
	          // Handle the exception here, log it, and return an appropriate error response.
	          return new ResponseEntity<>("Error processing sales data", HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	  }


	 
	  @GetMapping("/nbpro")
	  public ResponseEntity<Object> nbpro() {
	      List<Produit> ventes = Produit_rep.findAll();

	      if (!ventes.isEmpty()) {
	          int n = ventes.size();
	          return new ResponseEntity<>(n, HttpStatus.OK);
	      } else {
	          return new ResponseEntity<>("No sales found", HttpStatus.NOT_FOUND);
	      }
	  }
	  @GetMapping("/sales-per-month")
	    public ResponseEntity<List<Object[]>> getSalesPerMonth() {
	        List<Object[]> salesPerMonth =Vente_rep.countSalesPerMonth();
	        return new ResponseEntity<>(salesPerMonth, HttpStatus.OK);
	    }
	  @GetMapping("/vente_echoue")
	  public ResponseEntity<Object> vente_echoue() {
	       Vente  ventes = new Vente();

	      
	          return new ResponseEntity<>(ventes.getNbV(), HttpStatus.OK);
	      
	  }

	
	  
	  
	  
	  
	  
	  
	  
	  
	  //clame
	  
	  @PostMapping("/enregistrerclam")
	  public ResponseEntity<?> enregistrerclam(@Validated @RequestBody Clame p) {
	      try {
	          // You can add validation logic here if needed before saving the product
	          // For example, check if the product fields are valid

	    	  Clame savedP = Clame_rep.save(p);
	          return new ResponseEntity<>(savedP, HttpStatus.OK);
	      } catch (Exception e) {
	          // Handle any exceptions that may occur during the save operation
	          return new ResponseEntity<>("Failed to save the product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	  }
	  
	  @GetMapping("/listClameBYID/{id}")
		public ResponseEntity<Object> listClameBYID(@PathVariable(value = "id") long id) {
				Clame admin = Clame_rep.findById(id).get();
			 if(admin!=null)
			return new ResponseEntity<>(admin, HttpStatus.OK); 
			 else
				 return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND); 
				 
		}
		 
		@DeleteMapping("/deletclameBYID/{id}")
		public ResponseEntity<Object> deletclameBYID(@PathVariable(value = "id") long id) {
				Clame admin = Clame_rep.findById(id).get();
			 if(admin!=null) {
				 Clame_rep.delete(admin);return new ResponseEntity<>(admin, HttpStatus.OK);
			 }
			
			 else
				 return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND); 
				 
		}
		@GetMapping("/listclame")
		public ResponseEntity<Object> listclame() {
			List<Clame> admins = Clame_rep.findAll();
			 if(admins!=null)
			return new ResponseEntity<>(admins, HttpStatus.OK); 
			 else
				 return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND); 
				 
		}
	  
	  
	  
	  
	  
	  
	  
	  
	  //profil
	  @PostMapping("/enregistrerprofil")
	  public ResponseEntity<?> enregistrerprofil(@Validated @RequestBody Profil p) {
	      try {
	          // You can add validation logic here if needed before saving the product
	          // For example, check if the product fields are valid

	          Profil savedP = Profil_rep.save(p);
	          return new ResponseEntity<>(savedP, HttpStatus.OK);
	      } catch (Exception e) {
	          // Handle any exceptions that may occur during the save operation
	          return new ResponseEntity<>("Failed to save the product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	  }
	
	
	
	  @GetMapping("/getprofil/{id}")
		public ResponseEntity<Object> getprofil(@PathVariable(value = "id") long id) {
			Profil admin = Profil_rep.findByiduser(id);
			 if(admin!=null)
			return new ResponseEntity<>(admin, HttpStatus.OK); 
			 else
				 return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND); 
				 
		}
	
	
	
	  @PutMapping("/updatprofil/{id}")
	  public ResponseEntity<?> updatprofil(@RequestBody Profil p, @PathVariable(value = "id") long id) {
	      try {
	          Optional<Profil> existingProfil = Profil_rep.findById(id);
	          
	          if (existingProfil.isPresent()) {
	              Profil pp = existingProfil.get();
	              pp.setId_user(p.getId_user());
	              Profil savedP = Profil_rep.save(pp);
	              return new ResponseEntity<>(savedP, HttpStatus.OK);
	          } else {
	              return new ResponseEntity<>("Profil not found", HttpStatus.NOT_FOUND);
	          }
	      } catch (Exception e) {
	          // Handle any exceptions that may occur during the save operation
	          return new ResponseEntity<>("Failed to save the profil: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	  }

	
	
	
	 
	
	
	
	
}
