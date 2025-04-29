package add;

// 직접 만들어보는 ArrayList
public class MyArrayList<E> {
    private E[] elements;
    private int size;  // 현재 저장된 요소 수
    
    private  static final int DEFAULT_CAPACITY = 10;  //초기 용량

    public MyArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    
    // 내부 배열 크기 늘리기 (동적으로)
    private void ensureCapacity() {
        if (size >= elements.length) {
            int newCapacity = elements.length * 2;  // 배열 늘리기
            E[] newElements = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }
    
    // 맨 뒤에 요소 추가
    public void add(E value) {
        ensureCapacity();
        elements[size++] = value;  // 요초 추가후에 size 늘리기
    }

    // 특정 인덱스에 요소 삽입
    public void add(int index, E value) {
        if (index < 0 || index > size) {  // 인덱스 유효성 검사
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];  // 뒤에서부터 앞의 요소를 가져온다.
        }
        elements[index] = value;  // 비워졌으니 넣어준다.
        size++;
    }

    // 인덱스 요소 조회
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    // 인덱스로 요소 삭제
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E removedValue = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];  //앞에서부터 뒤에값을 당겨온다.
        }
        elements[size - 1] = null;  //  안쓰는 값은 null로
        size--;
        return removedValue;
    }

    // 현재 크기 반환
    public int size() {
        return size;
    }

    // 비어있는지 확인
    public boolean isEmpty() {
        return size == 0;
    }

    // 모든 요소 삭제
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
