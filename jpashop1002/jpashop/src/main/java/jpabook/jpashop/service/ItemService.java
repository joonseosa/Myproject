package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    //변경감지 기능 사용,  파라미터에 직접 get 을 해줘서 변경감지 기능사용됨 ㅡ itemRepository.save(book) 안해줘도됨
    //영속성 컨텐스트에서 엔티티를 다시 조회한후에 데이터를 수정
    //트랜잭션 안에서 데이터를 다시 조회,변경할 값 선택,트랜잭션 커밋 시점에 변경감지 동작해서 update sql 문 실행

    //변경감지 기능을 사용하면 원하는 속성만 바꿀수있지만,병합을 사용하면 모든 속성이 변경됨


    public void updateItem(Long itemId, String name,int price,int stockQuantity){
        Item findItem=itemRepository.findOne(itemId);
        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stockQuantity);

    }


    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }


}
